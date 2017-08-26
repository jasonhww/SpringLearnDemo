package org.hww.jdbctemplate;

import org.hww.jdbctemplate.databasepools.UserService;
import org.hww.jdbctemplate.tx.configmethod.beans.OrderService;
import org.hww.jdbctemplate.tx.notemethod.beans.OrderService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的操作
 */
public class JdbcTemplateDemo {

    @Test
    public void add() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO t_springtest VALUES (?,?)";
        int rows = jdbcTemplate.update(sql, 1, "22luhongkai22");
        System.out.println(rows);

    }

    @Test
    public void update() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE t_springtest SET id = ? WHERE name = ?";
        int rows = jdbcTemplate.update(sql, 2, "luhongkai");
        System.out.println(rows);
    }

    @Test
    public void delete() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE  FROM t_springtest WHERE name = ?";
        int rows = jdbcTemplate.update(sql, "22luhongkai22");
        System.out.println(rows);
    }

    //返回int值
    @Test
    public void query1() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM t_springtest";
        int rows = jdbcTemplate.queryForInt(sql);
        System.out.println(rows);
    }

    //返回一个对象
    @Test
    public void query2() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_springtest WHERE id = ?";
        //实现RowMapper接口
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        }, 2);
        System.out.println(user.getId() + ":" + user.getName());
    }

    //返回一个集合
    @Test
    public void query3() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        //创建JDBCTemplate对象,执行操作
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_springtest";
        //实现RowMapper接口
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        System.out.println(userList.size());
    }

    //测试数据库链接池的配置和注入过程
    @Test
    public void testC3P0Pool() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

    //测试事务管理操作-xml
    @Test
    public void testTransaction1() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.txAccount();
    }

    //测试事务管理操作-注解
    @Test
    public void testTransaction2() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        OrderService2 orderService2 = (OrderService2) context.getBean("orderService2");
        orderService2.txAccount();
    }
}
