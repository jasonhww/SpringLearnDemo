package org.hww.jdbctemplate.tx.notemethod.beans;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao2 {
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
