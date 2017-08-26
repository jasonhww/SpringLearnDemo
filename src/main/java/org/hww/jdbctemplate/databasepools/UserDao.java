package org.hww.jdbctemplate.databasepools;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() {
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        try {
//            comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("1234");
//        jdbcTemplate = new JdbcTemplate(comboPooledDataSource);
        String sql = "INSERT INTO t_springtest VALUES(?,?)";
        jdbcTemplate.update(sql,1,"xiaoyahui");
        System.out.println("UserDao.................");
    }
}
