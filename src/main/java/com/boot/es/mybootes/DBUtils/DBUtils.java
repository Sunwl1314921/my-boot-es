package com.boot.es.mybootes.DBUtils;

import java.io.FileReader;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @Description: 连接数据库的工具类, 被定义成不可继承且是私有访问
 */
public final class DBUtils {
    private static String url;
    private static String user;
    private static String psw;
    private static Connection connection;
    private PreparedStatement pstmt;// 有效的使SQL和参数分开，防止SQL注入，使程序更加健壮
    private ResultSet rs;

    public static void main(String[] args) throws Exception {
        connection = DBUtils.getConnection();
        System.out.println(connection);

        //查询
//        String sql = "select * from city where id > ?";
//        List<Object> params = new ArrayList<>();
//        params.add(2);
//        List<Map<String, Object>> mapList = new DBUtils().findResult(sql, params);
//        mapList.forEach(map -> map.forEach((k, v) -> System.out.println("key : " + k + "; value : " + v)));
        //新增
//        String sql = " insert into city (province,city_name,description) values(?,?,?)";
//        List<Object> params = new ArrayList<>();
//        params.add("你猜");
//        params.add("你猜我猜不猜");
//        params.add("你猜猜猜");
//        new DBUtils().updateByPreparedStatment(sql,params);

        //修改
//        String sql = " update  city set province= ? where id = ?";
//        List<Object> params = new ArrayList<>();
//        params.add("你猜aaa");
//        params.add("11");
//        new DBUtils().updateByPreparedStatment(sql,params);
        //删除
        String sql = " delete from city  where id = ?";
        List<Object> params = new ArrayList<>();
        params.add("12");
        new DBUtils().updateByPreparedStatment(sql,params);
        System.out.println("哦了");


    }

    //读取配置文件 的属性值 通过名字
    static String read(String name) throws Exception {
        Properties properties = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("src/main/java/com/boot/es/mybootes/DBUtils/jdbc.txt");//获取输入流
        properties.load(in);//将流加载到配置文件对象中
        in.close();
        return properties.getProperty(name);//返回根据key获取的value值
    }

    static {
        //方式一
        try {
            user = read("jdbc.username");
            psw = read("jdbc.passWd");
            url = read("jdbc.url");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("读取数据库文件异常", e);
        }
        //方式二
//        Properties prop = new Properties();
//        try {
//            prop.load(DBUtils.class.getResourceAsStream("/application.properties"));
//            user = prop.getProperty("jdbc.username");
//            psw = prop.getProperty("jdbc.passWd");
//            url = prop.getProperty("jdbc.url");
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("读取数据库文件异常", e);
//        }
    }

    // 防止通过构造器实例化
    private DBUtils() {
    }

    //获取数据库的连接
    static Connection getConnection() {
        if (null == connection) {
            try {
                connection = DriverManager.getConnection(url, user, psw);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    //释放资源 关闭链接
    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                if (null != pstmt) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        if (null != conn) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 执行修改添加删除操作
     *
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public boolean updateByPreparedStatment(String sql, List<?> params) throws SQLException {
        boolean flag = false;
        int result = -1;// 添加删除修改时所影响的数据库行数
        pstmt = connection.prepareStatement(sql);
        int index = 1;
        // 填充sql的占位符
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(index++, params.get(i));
            }
        }
        result = pstmt.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }

    /**
     * @param sql    带占位符 ？的sql
     * @param params 参数集合
     */
    List<Map<String, Object>> findResult(String sql, List<?> params) throws SQLException {
        sql = printRealSql(sql, params); // 打印真实 SQL 的函数

        List<Map<String, Object>> list = new ArrayList<>();
        pstmt = connection.prepareStatement(sql);//执行真实的sql
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = rs.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 在开发过程，SQL语句有可能写错，如果能把运行时出错的 SQL 语句直接打印出来，
     * 那对排错非常方便，因为其可以直接拷贝到数据库客户端进行调试。
     *
     * @param sql    SQL 语句，可以带有 ? 的占位符
     * @param params 插入到 SQL 中的参数，可单个可多个可不填
     * @return 实际 sql 语句
     */
    static String printRealSql(String sql, List<?> params) {
        if (params == null || params.size() == 0) {

            return sql;
        }
        Object[] values = params.toArray();

        for (int i = 0; i < params.size(); i++) {
            Object value = values[i];
            if (value instanceof Date) {
                values[i] = "'" + value + "'";
            } else if (value instanceof String) {
                values[i] = "'" + value + "'";
            } else if (value instanceof Boolean) {
                values[i] = (Boolean) value ? 1 : 0;
            }
        }

        sql = String.format(sql.replaceAll("\\?", "%s"), values);
        System.out.println(sql);
        return sql;
    }

}