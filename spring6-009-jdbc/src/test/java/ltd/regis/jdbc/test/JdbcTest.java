package ltd.regis.jdbc.test;

import ltd.regis.spring6.bean.User;
import ltd.regis.spring6.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcTest {

    @Test
    public void testCallBack() {

        //如果想写jdbc代码可以使用回调函数
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name, age from user where id = ?";

        //注册回调函数，当execute方法执行时，回调函数中的doInPreparedStatement会被调用
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, 3);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String realName = resultSet.getString("real_name");
                    int age = resultSet.getInt("age");
                    User user = new User(id, realName, age);
                    return user;
                }
                return null;
            }
        });

        System.out.println(user);


    }

    @Test
    public void testBatchDelete() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from user where id = ?";
        List<Object[]> list = new ArrayList<>();
        Object[] object1 = {7};
        Object[] object2 = {9};
        Object[] object3 = {10};
        list.add(object1);
        list.add(object2);
        list.add(object3);


        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        Arrays.stream(ints).forEach(System.out::println);


    }

    @Test
    public void testBatchUpdate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update user set real_name = ? where id = ?";
        List<Object[]> list = new ArrayList<>();
        Object[] object1 = {"宋七1", 6};
        Object[] object2 = { "二哈1", 7};
        Object[] object3 = {"程八1", 8};
        list.add(object1);
        list.add(object2);
        list.add(object3);

        int[] ints = jdbcTemplate.batchUpdate(sql, list);


    }

    @Test
    public void testAddBatch() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into user(id, real_name, age) value(?, ?, ?)";
        List<Object[]> list = new ArrayList<>();
        Object[] object1 = {null, "宋七", 27};
        Object[] object2 = {null, "二哈", 22};
        Object[] object3 = {null, "程八", 28};
        list.add(object1);
        list.add(object2);
        list.add(object3);

        int[] ints = jdbcTemplate.batchUpdate(sql, list);


    }
    @Test
    public void testQueryOneValue() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(1) from user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);


    }

    @Test
    public void testQuery() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from user";
        //查询多个直接用Query
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userList);
    }

    @Test
    public void testQueryForObject() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name from user where id = ?";
        //查询一个对象
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into user(real_name, age) value(?, ?)";
        String del_sql = "delete from user where id = ?";
        String update_sql = "update user set real_name = ? where id = ?";
//        增刪改都是update
//        jdbcTemplate.update(sql, "宋七", 27);
//        int update = jdbcTemplate.update(del_sql, 5);
//        System.out.println(update);
        int update = jdbcTemplate.update(update_sql, "王五", 3);
        System.out.println(update);
    }

    @Test
    public void testJdbc() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        System.out.println(jdbcTemplate);
//        int update = jdbcTemplate.update("update user set real_name = '33' where id = 3");
//        System.out.println(update);
        User user = context.getBean("user", User.class);
        System.out.println(user);


    }
}
