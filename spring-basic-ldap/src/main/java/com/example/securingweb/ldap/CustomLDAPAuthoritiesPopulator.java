package com.example.securingweb.ldap;

import com.unboundid.ldap.sdk.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import java.util.Collection;
import java.util.HashSet;

public class CustomLDAPAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    private Environment env;

    public CustomLDAPAuthoritiesPopulator(Environment env) {
        this.env = env;
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dirContextOperations, String userCn) {
        try {

            String baseDn = env.getProperty("spring.ldap.embedded.base-dn");
            String managerDn = env.getProperty("spring.ldap.embedded.manager-dn");
            String bindPassword = null != env.getProperty("spring.ldap.embedded.password") ? env.getProperty("spring.ldap.embedded.password") : "";
            Integer port = Integer.parseInt(env.getProperty("spring.ldap.embedded.port"));
            // Create LDAP connection
            LDAPConnection ldapConnection = new LDAPConnection("localhost", port);
            ldapConnection.bind(managerDn, bindPassword);

            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();

            SearchResultEntry userEntry = ldapConnection.searchForEntry(
                    baseDn,
                    SearchScope.SUB,
                    Filter.createEqualityFilter("uid", userCn)
            );

            if (userEntry != null) {
                String userDn = userEntry.getDN();

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

                    System.out.println("User " + userCn + " is a member of group: " + authority);
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
                    grantedAuthorities.add(grantedAuthority);
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
}