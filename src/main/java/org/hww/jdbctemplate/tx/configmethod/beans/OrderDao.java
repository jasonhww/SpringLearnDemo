package org.hww.jdbctemplate.tx.configmethod.beans;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lessMoney() {
        String sql = "update t_salarys set salary = salary -? where username = ?";
        jdbcTemplate.update(sql, 1000, "小卢");
    }

    public void addMoney() {
        String sql = "update t_salarys set salary = salary +? where username = ?";
        jdbcTemplate.update(sql, 1000, "小肖");
    }
}
