package com.example.securingweb;

import com.example.securingweb.h2.UserAccountRepository;
import com.example.securingweb.ldap.CustomAuthoritiesPopulator;
import com.example.securingweb.ldap.CustomLDAPAuthoritiesPopulator;
import com.example.securingweb.ldap.CustomUserDetailsMapper;
import com.unboundid.ldap.sdk.LDAPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

	private final UserAccountRepository userAccountRepository;

	private Environment env;

	private LdapContextSource contextSource;

	public WebSecurityConfig(UserAccountRepository userAccountRepository, Environment env, LdapContextSource contextSource) {
		this.userAccountRepository = userAccountRepository;
		this.env = env;
		this.contextSource = contextSource;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers(HttpMethod.GET, "/register.html").permitAll()
				.antMatchers(HttpMethod.POST, "/register").permitAll()
//				.antMatchers("/home").hasRole("USER")
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/catalog/**").hasRole("CATALOG_MGR")
				.anyRequest().authenticated()
			)

			.formLogin((form) -> form
				.loginPage("/login")
				.successForwardUrl("/home")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			.headers().frameOptions().disable()
			;

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		if(env.getProperty("spring.ldap.internal").equals("true")){

//			try {
//				String ldapUrl = null != env.getProperty("spring.ldap.embedded.urls")? env.getProperty("spring.ldap.embedded.urls"):"";
//				String bindDn = env.getProperty("spring.ldap.embedded.base-dn");
//				String bindPassword = env.getProperty("spring.ldap.embedded.base-dn");
//				// Create LDAP connection
//				LDAPConnection ldapConnection = new LDAPConnection(ldapUrl);
//				ldapConnection.bind(bindDn, bindPassword);
//
//			} catch (Exception e) {
//
//			}

			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.ldapAuthoritiesPopulator(new CustomLDAPAuthoritiesPopulator(env))
					.userDetailsContextMapper(new CustomUserDetailsMapper())
//					.userSearchBase(env.getProperty("spring.ldap.embedded.base-dn"))
					.userDnPatterns(env.getProperty("spring.ldap.embedded.dn-patterns"))
					.groupSearchBase(env.getProperty("spring.ldap.embedded.search-base"))
					.contextSource()
					.url(env.getProperty("spring.ldap.embedded.urls")+":"+env.getProperty("spring.ldap.embedded.port")+"/"+env.getProperty("spring.ldap.embedded.base-dn"))
					.port(Integer.parseInt(env.getProperty("spring.ldap.embedded.port")))
					.managerDn(env.getProperty("spring.ldap.embedded.manager-dn"))
					.managerPassword(env.getProperty("spring.ldap.embedded.password"))
					.and()
					.passwordCompare()
//					.passwordEncoder(new BCryptPasswordEncoder())
					.passwordAttribute("userPassword");;

		} else {
			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.userDetailsContextMapper(new CustomUserDetailsMapper())
					.ldapAuthoritiesPopulator(new CustomLDAPAuthoritiesPopulator(env))
					.userDnPatterns(env.getProperty("spring.ldap.dn-patterns"))
					.userSearchBase(env.getProperty("spring.ldap.search-base"))
					.contextSource()
					.url(env.getProperty("spring.ldap.url"))
					.managerDn(env.getProperty("spring.ldap.manager-dn"))
					.managerPassword(env.getProperty("spring.ldap.password"));

		}

	}
}
