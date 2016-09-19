package cn.zjc.service;

import cn.zjc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/19 12:07
 * @function
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> queryUserById(Integer id) {
        RowMapper<User> rm = BeanPropertyRowMapper.newInstance(User.class);
        return jdbcTemplate.query("SELECT * FROM USER WHERE ID = ?",new Object[]{id},rm);
    }
}
