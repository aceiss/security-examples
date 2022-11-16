package com.example.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/").permitAll()
				.antMatchers(HttpMethod.GET, "/register.html").permitAll()
				.antMatchers(HttpMethod.POST, "/register").permitAll()
				.antMatchers("/home").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/catalog/**").hasRole("CATALOG_MGR")
				.anyRequest().authenticated()
			)

			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
		;

		return http.build();
	}


/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		UserDetails user2 =
			User.withDefaultPasswordEncoder()
			   	.username("adminb")
			   	.password("password")
			   	.roles("USER","ADMIN","CATALOG_MGR")
			   	.build();

	    UserDetails user3 =
		    User.withDefaultPasswordEncoder()
			   	.username("catmgr")
			   	.password("password")
			   	.roles("USER","CATALOG_MGR")
			   	.build();
   
		return new InMemoryUserDetailsManager(user, user2, user3);
	}
*/
}
