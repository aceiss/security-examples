package com.example.securingweb.h2;

import com.example.securingweb.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInitializer {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initializeData() {
        System.out.println("MADE IT HERE");
        String encodedPwd = null;
        try {
            encodedPwd = EncoderUtil.getSHA256("password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
            + "values ('admin', '" + encodedPwd + "','Don Admin', 'Don', 'Admin','123 State St.', 1, 'admin@email.com')");

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
            + "values ('catmgr', '" + encodedPwd + "','Adam Catty', 'Adam', 'Catty','12345 Harrison St.', 1, 'catmgr@email.com')");

        jdbcTemplate.execute("insert into roles (username, role) "
            + "values ('catmgr', 'CATALOG_MGR')");

        jdbcTemplate.execute("insert into roles (username, role) "
            + "values ('catmgr', 'USER')");

        jdbcTemplate.execute("insert into business_unit (username, business_unit) "
            + "values ('catmgr', 'CATALOG_BU')");

        jdbcTemplate.execute("insert into business_unit (username, business_unit) "
            + "values ('catmgr', 'FINANCE_BU')");

        jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
            + "values ('user', '" + encodedPwd + "', 'Matt Useless','Matt', 'Useless','123 Maridian St.', 1, 'user@email.com')");

        jdbcTemplate.execute("insert into roles (username, role) "
            + "values ('user', 'USER')");

        jdbcTemplate.execute("insert into business_unit (username, business_unit) "
            + "values ('user', 'USER_BU')");

        jdbcTemplate.execute("insert into business_unit (username, business_unit) "
            + "values ('user', 'FINANCE_BU')");

        jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Don.Admin', '" + encodedPwd + "', 'Don Admin', 'Don', 'Admin','12323 State St.', 1, 'Don.Admin@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Don.Admin', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Don.Admin', 'CATALOG_MGR')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Don.Admin', 'USER')");

                jdbcTemplate.execute("insert into business_unit (username, business_unit) "
                        + "values ('Don.Admin', 'ADMIN_BU')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('Jill.User', '" + encodedPwd + "', 'Jill User', 'Jill', 'User','1233 State St.', 1, 'Jill.User@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Jill.User', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('Jill.User', 'USER')");

                jdbcTemplate.execute("insert into employees (username, password, name, first_name, last_name, address, enabled, email) "
                        + "values ('MillerA', '" + encodedPwd + "', 'Ava Miller', 'Ava', 'Miller','1233 State St.', 1, 'avamiller@aceiss.com')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('MillerA', 'ADMIN')");

                jdbcTemplate.execute("insert into roles (username, role) "
                        + "values ('MillerA', 'USER')");

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
}
