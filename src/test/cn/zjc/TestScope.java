package cn.zjc;

import cn.zjc.entity.User;
import cn.zjc.sql.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author zhangjinci
 * @version 2016/9/19 10:54
 * @function
 */
public class TestScope {


    @Test
    public void Test1() throws Exception {
        Connection conn = JdbcUtils.getMysqlConn();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM USER WHERE ID = ?");
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        User u = new User();
        while (resultSet.next()) {
            u.setId(resultSet.getInt("ID"));
            u.setName(resultSet.getString("NAME"));
            u.setBirth(resultSet.getTimestamp("BIRTH"));
        }
        System.out.println(u);
        JdbcUtils.release(conn, preparedStatement, resultSet);
    }
}
