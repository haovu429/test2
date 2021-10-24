package murach.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            System.out.println("Da vao khoi tao Pool");
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)
                    ic.lookup("java:/comp/env/jdbc/murach");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
    private ConnectionPool(ConnectionPool connectionPool) {
        this.pool = connectionPool.getPool();
        this.dataSource = connectionPool.getDataSource();
    }
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            System.out.println("Da chay vao get con");
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ConnectionPool getPool() {
        return pool;
    }

    public static void setPool(ConnectionPool pool) {
        ConnectionPool.pool = pool;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        ConnectionPool.dataSource = dataSource;
    }
}
