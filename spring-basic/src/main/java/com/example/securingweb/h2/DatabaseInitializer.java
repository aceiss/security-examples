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

                jdbcTemplate.execute("insert into employees (username, password, first_name, last_name, address, enabled) "
                        + "values ('admin', '" + encodedPwd + "', 'Don', 'Admin','123 State St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('admin', 'DEVELOPMENT_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('admin', 'FINANCE_BU')");

                jdbcTemplate.execute("insert into employees (username, password, first_name, last_name, address, enabled) "
                        + "values ('catmgr', '" + encodedPwd + "', 'Adam', 'Catty','12345 Harrison St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('catmgr', 'CATALOG_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('catmgr', 'FINANCE_BU')");

                jdbcTemplate.execute("insert into employees (username, password, first_name, last_name, address, enabled) "
                        + "values ('user', '" + encodedPwd + "', 'Matt', 'Useless','123 Maridian St.', 1)");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('user', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('user', 'USER_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('user', 'FINANCE_BU')");

            }
        };
    }
}