package com.aceiss.springhib4;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
            .create()
            .url("jdbc:h2:mem:~/userDB")
            .driverClassName("org.h2.Driver")
            .username("sa")
            .password("sa")
            .build();
    }
}
