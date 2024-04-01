package com.example.securingweb.ldap;

import com.unboundid.ldap.sdk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.w3c.dom.Attr;

import java.util.*;

public class CustomLDAPAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    private Environment env;

    public CustomLDAPAuthoritiesPopulator(Environment env) {
        this.env = env;
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dirContextOperations, String userCn) {
        try {

            String internalLdap = env.getProperty("spring.ldap.internal");
            String baseDn = null;
            String managerDn = null;
            String bindPassword = null;
            Integer port = null;
            LDAPConnection ldapConnection = null;
            String cNFilter = null;

            if(internalLdap.equals("true")){
                baseDn = env.getProperty("spring.ldap.embedded.base-dn");
                managerDn = env.getProperty("spring.ldap.embedded.manager-dn");
                bindPassword = null != env.getProperty("spring.ldap.embedded.password") ? env.getProperty("spring.ldap.embedded.password") : "";
                port = Integer.parseInt(env.getProperty("spring.ldap.embedded.port"));
                // Create LDAP connection
                ldapConnection = new LDAPConnection("localhost", port);
                ldapConnection.bind(managerDn, bindPassword);
                cNFilter = "uid";
            } else {
                baseDn = env.getProperty("spring.ldap.search-base");
                managerDn = env.getProperty("spring.ldap.manager-dn");
                bindPassword = null != env.getProperty("spring.ldap.password") ? env.getProperty("spring.ldap.password") : "";
                port = Integer.parseInt(env.getProperty("spring.ldap.external.port"));
                // Create LDAP connection
                ldapConnection = new LDAPConnection(env.getProperty("spring.ldap.external.host"), port);
                ldapConnection.bind(managerDn, bindPassword);
                cNFilter = "CN";
            }

            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();

            SearchResultEntry userEntry = ldapConnection.searchForEntry(
                    baseDn,
                    SearchScope.SUB,
                    Filter.createEqualityFilter(cNFilter, userCn)
            );

            if (userEntry != null) {
                String userDn = userEntry.getDN();
                if(internalLdap.equals("true")){
                    extractAuthoritiesInternal(userCn, baseDn, ldapConnection, grantedAuthorities, userDn);
                } else {
                    extractAuthoritiesExternal(userCn, grantedAuthorities, userEntry);
                }
            } else {
                System.out.println("User " + userCn + " not found.");
            }
            return grantedAuthorities;
        } catch (LDAPException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void extractAuthoritiesExternal(String userCn, Collection<GrantedAuthority> grantedAuthorities, SearchResultEntry userEntry) {
        String[] attributes = userEntry.getAttribute("memberof").getValues();
        String authority = null;
        for (String attribute: attributes){
            String[] parts = attribute.split(",");

            for (String part : parts) {
                if (part.trim().startsWith("CN=")) {
                    // Extract the value after "cn="
                    authority = part.trim().substring(3);
                    break;
                }
            }
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
            grantedAuthorities.add(grantedAuthority);
        }
    }

    private static void extractAuthoritiesInternal(String userCn, String baseDn, LDAPConnection ldapConnection, Collection<GrantedAuthority> grantedAuthorities, String userDn) throws LDAPSearchException {
        // Create filter to search for group entries containing user DN in uniqueMember attribute
        Filter groupFilter = Filter.createEqualityFilter("uniqueMember", userDn);
        Filter objectClassFilter = Filter.createEqualityFilter("objectClass", "groupOfUniqueNames");
        Filter searchFilter = Filter.createANDFilter(groupFilter, objectClassFilter);

        // Search for group entries containing user DN in uniqueMember attribute
        SearchResult searchResult = ldapConnection.search(
                baseDn,
                SearchScope.SUB,
                searchFilter,
                "cn"
        );

        for (SearchResultEntry groupEntry : searchResult.getSearchEntries()) {
            // Print group CN or any other relevant information

            String[] parts = groupEntry.getDN().split(",");
            String authority = null;
            for (String part : parts) {
                if (part.trim().startsWith("cn=")) {
                    // Extract the value after "cn="
                    authority = part.trim().substring(3);
                    break;
                }
            }
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
            grantedAuthorities.add(grantedAuthority);
        }
    }
}