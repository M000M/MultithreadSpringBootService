package demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String username, int threadId, String threadStatus) {
        String sql = "insert into userthread (username, thread_id, thread_status) values (?, ?, ?) ";
        jdbcTemplate.update(sql, new Object[]{username, threadId, threadStatus});
    }

    public void update(String username, int threadId, String threadStatus) {
        String sql = "update userthread set thread_status=? where username=? and thread_id=?";
        jdbcTemplate.update(sql, new Object[]{threadStatus, username, threadId});
    }
}