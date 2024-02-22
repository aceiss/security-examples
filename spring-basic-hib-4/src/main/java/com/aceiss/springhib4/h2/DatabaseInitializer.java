package com.aceiss.springhib4.h2;

import com.aceiss.springhib4.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

                // Create a new session
                try {
                    Session session = sessionFactory.openSession();
                    // Begin a transaction
                    session.beginTransaction();

                    // Commit the transaction, which will trigger the table creation
                    session.getTransaction().commit();
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

                // Close the SessionFactory
                sessionFactory.close();


/*
                jdbcTemplate.execute(" create table employees (\n" +
                    "       username varchar(255) not null,\n" +
                    "        address varchar(300) not null,\n" +
                    "        email varchar(300) not null,\n" +
                    "        enabled varchar(2) not null,\n" +
                    "        firstname varchar(300) not null,\n" +
                    "        lastname varchar(300) not null,\n" +
                    "        name varchar(300) not null,\n" +
                    "        password varchar(300) not null,\n" +
                    "        primary key (username)\n" +
                    "    )\n");

                jdbcTemplate.execute("  create table roles (\n" +
                    "       id integer generated by default as identity,\n" +
                    "        role varchar(30) not null,\n" +
                    "        username varchar(30) not null,\n" +
                    "        primary key (id)\n" +
                    "    )\n");

                jdbcTemplate.execute(" create table user_roles (\n" +
                    "       id integer generated by default as identity,\n" +
                    "        role varchar(30) not null,\n" +
                    "        username varchar(30) not null,\n" +
                    "        primary key (id)\n" +
                    "    )\n");

                jdbcTemplate.execute(" alter table roles \n" +
                    "       add constraint FKjug8hdyvml6msd0o65wwjqsg9 \n" +
                    "       foreign key (username) \n" +
                    "       references employees\n");
*/

                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//                String encodedPwd = passwordEncoder.encode("password");
                String encodedPwd = "password";

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('admin', '" + encodedPwd + "','Don Admin', 'Don', 'Admin','123 State St.', 1, 'admin@mail.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('admin', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('admin', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('admin', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('catmgr', '" + encodedPwd + "','Adam Catty', 'Adam', 'Catty','12345 Harrison St.', 1, 'catmgr@mail.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('catmgr', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('catmgr', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                    + "values ('user', '" + encodedPwd + "','Matt Useless', 'Matt', 'Useless','123 Maridian St.', 1,'user@email.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('user', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('Jill.User', '" + encodedPwd + "', 'Jill User', 'Jill', 'User','1233 State St.', 1, 'Jill.User@aceiss.com')");

//                jdbcTemplate.execute("insert into roles (username, role) "
//                    + "values ('Jill.User', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Jill.User', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('MillerA', '" + encodedPwd + "', 'Ava Miller', 'Ava', 'Miller','1233 State St.', 1, 'avamiller@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('MillerA', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('MillerA', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('RobinsonA', '" + encodedPwd + "', 'Ava Robinson', 'Ava', 'Robinson','12334 State St.', 1, 'avarobinson@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('RobinsonA', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('RobinsonA', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('BakerE', '" + encodedPwd + "', 'Eric Baker', 'Eric', 'Baker','345 Wedge Way', 1, 'ericbaker@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('BakerE', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('BakerE', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('Allan.Burton', '" + encodedPwd + "', 'Allan Burton','Allan', 'Burton', '1244 Golf St.', 1, 'Allen.Burton@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Allan.Burton', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Allan.Burton', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into employees (username, password, name, firstname, lastname, address, enabled, email) "
                    + "values ('Andrea.Hudson', '" + encodedPwd + "', 'Andrea Hudson','Andrea', 'Hudson', '12434 Golfing St.', 1, 'Andrea.Hudson@sailpointdemo.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Andrea.Hudson', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                    + "values ('Andrea.Hudson', 'CATALOG_MGR')");
            }
        };
    }
}
