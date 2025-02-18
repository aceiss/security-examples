package com.example.securingweb;

import com.example.securingweb.h2.UserAccountRepository;
import com.example.securingweb.ldap.CustomAuthoritiesPopulator;
import com.example.securingweb.ldap.CustomLDAPAuthoritiesPopulator;
import com.example.securingweb.ldap.CustomUserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.search.LdapUserSearch;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.web.SecurityFilterChain;


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
//		auth.authenticationProvider(ldapAuthenticationProvider());

		if(env.getProperty("spring.ldap.internal").equals("true")){

			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.userSearchFilter(env.getProperty("spring.ldap.embedded.login.search-filter"))
					.ldapAuthoritiesPopulator(new CustomLDAPAuthoritiesPopulator(env))
//					.ldapAuthoritiesPopulator(new CustomAuthoritiesPopulator(userAccountRepository))
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
					.passwordAttribute("userPassword");


		} else {
			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.userDetailsContextMapper(new CustomUserDetailsMapper())
					.ldapAuthoritiesPopulator(new CustomLDAPAuthoritiesPopulator(env))
//					.ldapAuthoritiesPopulator(new CustomAuthoritiesPopulator(userAccountRepository))
					.userDnPatterns(env.getProperty("spring.ldap.dn-patterns"))
					.userSearchBase(env.getProperty("spring.ldap.search-base"))
					.contextSource()
					.url(env.getProperty("spring.ldap.url"))
					.managerDn(env.getProperty("spring.ldap.manager-dn"))
					.managerPassword(env.getProperty("spring.ldap.password"));
		}
	}
//Not used yet
	@Bean
	public BindAuthenticator bindAuthenticator() {

		//Configure the user search parameters
		LdapUserSearch userSearch = null;
		if(env.getProperty("spring.ldap.internal").equals("true")){
			userSearch = new FilterBasedLdapUserSearch(env.getProperty("spring.ldap.embedded.dn-patterns"), env.getProperty("spring.ldap.embedded.login.search-filter"), contextSource);
		} else {
			userSearch = new FilterBasedLdapUserSearch(env.getProperty("spring.ldap.dn-patterns"), env.getProperty("spring.ldap.external.login.search-filter"), contextSource);
		}
		// Configure BindAuthenticator
		BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource);
		bindAuthenticator.setUserSearch(userSearch);
		return bindAuthenticator;
	}

	@Bean
	public LdapAuthenticationProvider ldapAuthenticationProvider() {
		// Configure LDAP authentication provider
		return new LdapAuthenticationProvider(bindAuthenticator(), new DefaultLdapAuthoritiesPopulator(contextSource, ""));
	}
}
