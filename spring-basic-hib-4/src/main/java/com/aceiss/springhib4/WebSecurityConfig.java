package com.aceiss.springhib4;

import com.aceiss.springhib4.h2.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebApplicationContext applicationContext;

    private DatabaseUserDetailsService databaseUserDetailsService;

    public WebSecurityConfig() {
    }
    @PostConstruct
    public void completeSetup() {
        databaseUserDetailsService = applicationContext.getBean(DatabaseUserDetailsService.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(databaseUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            // Spring Security should completely ignore URLs starting with /resources/
            .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.GET,"/register.html").permitAll()
            .antMatchers(HttpMethod.POST,"/register").permitAll()
            .antMatchers(HttpMethod.POST,"/login2").permitAll()
            .anyRequest().authenticated();

        http.formLogin().loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login-error").permitAll();
        http.logout().permitAll();
        http.csrf().disable();

        http.headers().frameOptions().disable();
    }

}
