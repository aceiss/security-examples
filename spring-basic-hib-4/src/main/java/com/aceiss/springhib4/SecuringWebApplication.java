package com.aceiss.springhib4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

//@EnableJpaRepositories("com.aceiss.springhib4.h2")

@SpringBootApplication
public class SecuringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuringWebApplication.class, args);
	}

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        return factory;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.aceiss.springhib4.h2"); // Package where your entities are located
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }
}
