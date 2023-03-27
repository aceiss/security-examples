package com.example.securingweb.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseInitializer {

    @Autowired JdbcTemplate jdbcTemplate;


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPwd = passwordEncoder.encode("password");

                jdbcTemplate.execute("insert into employees (email, password, first_name, last_name, address, enabled) "
                        + "values ('admin@mail.com', '" + encodedPwd + "', 'Don', 'Admin','123 State St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin@mail.com', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin@mail.com', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin@mail.com', 'USER')");

                jdbcTemplate.execute("insert into employees (email, password, first_name, last_name, address, enabled) "
                        + "values ('catmgr@mail.com', '" + encodedPwd + "', 'Adam', 'Catty','12345 Harrison St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr@mail.com', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr@mail.com', 'USER')");

                jdbcTemplate.execute("insert into employees (email, password, first_name, last_name, address, enabled) "
                        + "values ('user@mail.com', '" + encodedPwd + "', 'Matt', 'Useless','123 Maridian St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('user@mail.com', 'USER')");
            }
        };
    }
}