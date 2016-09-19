package cn.zjc.sql;

import com.alibaba.druid.pool.DruidDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhangjinci
 * @version 2016/9/19 10:46
 * @function 不使用spring的时候从JNDI获取数据源以及数据库连接
 */
public class JdbcUtils {

    /*
     web.xml文件中的JNDI数据源引用配置

     <!--Oracle数据库JNDI数据源引用 -->
     <resource-ref>
     <description>Oracle DB Connection</description>
     <res-ref-name>jdbc/OracleDataSource</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
     </resource-ref>

     <!--MySQL数据库JNDI数据 -->
     <resource-ref>
     <description>MySQL DB Connection</description>
     <res-ref-name>jdbc/MysqlDataSource</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
     </resource-ref>

     <!--SQLServer数据库JNDI数据源引用 -->
     <resource-ref>
     <description>SQLServer DB Connection</description>
     <res-ref-name>jdbc/SqlServerDataSource</res-ref-name>
     <res-type>javax.sql.DataSource</res-type>
     <res-auth>Container</res-auth>
     </resource-ref>
     */

    //Oracle数据库配置的JNDI数据源连接名,后面跟的是DataSource名，DataSource名在web.xml文件中的<res-ref-name></res-ref-name>进行了配置
    //MySQL数据库配置的JNDI数据源连接名，java:comp/env是必须加的,后面跟的是DataSource名
    //SQLServer数据库配置的JNDI数据源连接名，java:comp/env是必须加的,后面跟的是DataSource名

    //由于没有安装其他两个数据库,只测试mysql
    private final static String MYSQL_DATABASE_JDNINAME = "jdbc/MysqlDataSource";
    private static DruidDataSource druidDataSource = null;

    static {
        try {
            Context context = new InitialContext();
            Context envContext = (Context)context.lookup("java:comp/env");
            druidDataSource = (DruidDataSource) envContext.lookup(MYSQL_DATABASE_JDNINAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getMysqlConn() throws SQLException {
        return druidDataSource.getConnection();
    }


    public static void release(Connection conn, PreparedStatement st, ResultSet rs) {
        if (rs != null) {
            try {
                //关闭存储查询结果的ResultSet对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                //关闭负责执行SQL命令的Statement对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                //关闭Connection数据库连接对象
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
