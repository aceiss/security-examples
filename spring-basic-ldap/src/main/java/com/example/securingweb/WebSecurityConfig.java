package com.example.securingweb;

import com.example.securingweb.h2.UserAccountRepository;
import com.example.securingweb.ldap.CustomAuthoritiesPopulator;
import com.example.securingweb.ldap.CustomUserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

	private final UserAccountRepository userAccountRepository;

	private Environment env;

	public WebSecurityConfig(UserAccountRepository userAccountRepository, Environment env) {
		this.userAccountRepository = userAccountRepository;
		this.env = env;
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
			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.ldapAuthoritiesPopulator(new CustomAuthoritiesPopulator(userAccountRepository))
					.userDetailsContextMapper(new CustomUserDetailsMapper())
					.userDnPatterns(env.getProperty("spring.ldap.embedded.dn-patterns"))
					.groupSearchBase(env.getProperty("spring.ldap.embedded.search-base"))
					.contextSource()
					.url(env.getProperty("spring.ldap.embedded.urls"))
					.and()
					.passwordCompare()
					.passwordEncoder(new BCryptPasswordEncoder())
					.passwordAttribute("userPassword");;

		} else {
			auth
					// https://spring.io/guides/gs/authenticating-ldap/
					.ldapAuthentication()
					.userDetailsContextMapper(new CustomUserDetailsMapper())
					.ldapAuthoritiesPopulator(new CustomAuthoritiesPopulator(userAccountRepository))
					.userDnPatterns(env.getProperty("spring.ldap.dn-patterns"))
					.userSearchBase(env.getProperty("spring.ldap.search-base"))
					.contextSource()
					.url(env.getProperty("spring.ldap.urls"))
					.managerDn(env.getProperty("spring.ldap.manager-dn"))
					.managerPassword(env.getProperty("spring.ldap.password"));

		}

	}
}
