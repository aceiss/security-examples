package com.aceiss.springhib6.h2;

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

/*
                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Sam.Cooper', '" + encodedPwd + "', 'Sam Cooper', 'Sam', 'Cooper','12323 State St.', 1, 'Sam.Cooper@demoexample.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Sam.Cooper', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Sam.Cooper', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Sam.Cooper', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('Paul.Walker', '" + encodedPwd + "', 'Paul Walker', 'Paul', 'Walker','12323 State St.', 1, 'Paul.Walker@demoexample.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Paul.Walker', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Paul.Walker', 'CATALOG_MGR')");
*/

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('admin', '" + encodedPwd + "','Don Admin', 'Don', 'Admin','123 State St.', 1, 'admin@mail.com')");

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

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('catmgr', '" + encodedPwd + "','Adam Catty', 'Adam', 'Catty','12345 Harrison St.', 1, 'catmgr@mail.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('catmgr', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('catmgr', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('catmgr', 'CATALOG_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('catmgr', 'FINANCE_BU')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('user', '" + encodedPwd + "','Matt Useless', 'Matt', 'Useless','123 Maridian St.', 1,'user@email.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('user', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('user', 'USER_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('user', 'FINANCE_BU')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Jill.User', '" + encodedPwd + "', 'Jill User', 'Jill', 'User','1233 State St.', 1, 'Jill.User@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Jill.User', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('Jill.User', 'USER_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('Jill.User', 'FINANCE_BU')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('MillerA', '" + encodedPwd + "', 'Ava Miller', 'Ava', 'Miller','1233 State St.', 1, 'avamiller@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('MillerA', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('MillerA', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('MillerA', 'USER_BU')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('MillerA', 'DEVELOPMENT_BU')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('RobinsonA', '" + encodedPwd + "', 'Ava Robinson', 'Ava', 'Robinson','12334 State St.', 1, 'avarobinson@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('RobinsonA', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('RobinsonA', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('BakerE', '" + encodedPwd + "', 'Eric Baker', 'Eric', 'Baker','345 Wedge Way', 1, 'ericbaker@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('BakerE', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('BakerE', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Allan.Burton', '" + encodedPwd + "', 'Allan Burton','Allan', 'Burton', '1244 Golf St.', 1, 'Allen.Burton@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Allan.Burton', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Allan.Burton', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Andrea.Hudson', '" + encodedPwd + "', 'Andrea Hudson','Andrea', 'Hudson', '12434 Golfing St.', 1, 'Andrea.Hudson@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Andrea.Hudson', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Andrea.Hudson', 'CATALOG_MGR')");
            }
        };
    }
}
