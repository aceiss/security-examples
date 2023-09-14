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

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('admin', '" + encodedPwd + "', 'Don Admin', 'Don', 'Admin','123 State St.', 1, 'admin@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('admin', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('catmgr', '" + encodedPwd + "', 'Adam Catty', 'Adam', 'Catty','12345 Harrison St.', 1, 'catmgr@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('catmgr', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('user', '" + encodedPwd + "', 'Matt Useless', 'Matt', 'Useless','123 Maridian St.', 1, 'user@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('user', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Michael.Miller', '" + encodedPwd + "', 'Michael Miller', 'Michael', 'Miller','129 State St.', 1, 'Michael.Miller@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Michael.Miller', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Michael.Miller', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Michael.Miller', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Maria.White', '" + encodedPwd + "', 'Maria White', 'Maria', 'White','122 State St.', 1, 'Maria.White@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Maria.White', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Maria.White', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Maria.White', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Charles.Harris', '" + encodedPwd + "', 'Charles Harris','Charles', 'Harris', '1244 State St.', 1, 'Charles.Harris@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Charles.Harris', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Charles.Harris', 'CATALOG_MGR')");
            }
        };
    }
}