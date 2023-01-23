package com.example.registrationlogindemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseInitializer {

    @Autowired JdbcTemplate jdbcTemplate;


//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPwd = passwordEncoder.encode("password");

                jdbcTemplate.execute("insert into roles (id, name) VALUES(default,'ROLE_ADMIN')");

                int adminRoleId = jdbcTemplate.queryForObject("select id from roles where name = 'ROLE_ADMIN'", Integer.class);

                jdbcTemplate.execute("insert into roles (id, name) VALUES(default,'ROLE_CATALOG_MGR')");

                int catRoleId = jdbcTemplate.queryForObject("select id from roles where name = 'ROLE_CATALOG_MGR'", Integer.class);

                jdbcTemplate.execute("insert into roles (id, name) VALUES(default,'ROLE_USER')");

                int userRoleId = jdbcTemplate.queryForObject("select id from roles where name = 'ROLE_USER'", Integer.class);

                jdbcTemplate.execute("insert into users ( password, first_name, last_name, address, enabled, email) "
                        + "values ('" + encodedPwd + "', 'Don', 'Admin','123 State St.', 1, 'admin@mail.com')");

                int adminUserId = jdbcTemplate.queryForObject("select id from users where email = 'admin@mail.com'", Integer.class);

                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + adminUserId + "','" + adminRoleId +"')");


                jdbcTemplate.execute("insert into users (password, first_name, last_name, address, enabled, email) "
                        + "values ('" + encodedPwd + "', 'Adam', 'Catty','12345 Harrison St.', 1, 'catmgr@mail.com')");

                int catUserId = jdbcTemplate.queryForObject("select id from users where email = 'catmgr@mail.com'", Integer.class);

                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + catUserId + "','" + catRoleId +"')");
                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + adminUserId + "','" + catRoleId +"')");


                jdbcTemplate.execute("insert into users ( password, first_name, last_name, address, enabled, email) "
                        + "values ( '" + encodedPwd + "', 'Matt', 'Useless','123 Maridian St.', 1, 'user@mail.com')");

                int userUserId = jdbcTemplate.queryForObject("select id from users where email = 'user@mail.com'", Integer.class);

                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + catUserId + "','" + userRoleId +"')");
                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + adminUserId + "','" + userRoleId +"')");
                jdbcTemplate.execute("insert into users_roles (user_id, role_id) VALUES('" + userUserId + "','" + userRoleId +"')");

            }
        };
    }
}