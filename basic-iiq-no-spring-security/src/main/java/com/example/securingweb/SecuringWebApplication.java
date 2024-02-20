package com.example.securingweb;

import com.example.securingweb.h2.DatabaseInitializer;
import com.example.securingweb.servlet.MainServlet;
import com.example.securingweb.servlet.UpdateServlet;
import com.example.securingweb.servlet.UserLoginServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SecuringWebApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SecuringWebApplication.class);
    }

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SecuringWebApplication.class, args);
	}
    // Enable H2 Console
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean<UserLoginServlet> userLoginServlet() {
        ServletRegistrationBean<UserLoginServlet> registrationBean =
            new ServletRegistrationBean<>(new UserLoginServlet(), "/u_login");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean<MainServlet> mainServlet() {
        ServletRegistrationBean<MainServlet> registrationBean =
            new ServletRegistrationBean<>(new MainServlet(), "/main");
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean<UpdateServlet> updateServlet() {
        ServletRegistrationBean<UpdateServlet> registrationBean =
            new ServletRegistrationBean<>(new UpdateServlet(), "/update");
        return registrationBean;
    }

    @Bean
    public CommandLineRunner init(DatabaseInitializer dataInitializationService) {
        return args -> dataInitializationService.initializeData();
    }
}
