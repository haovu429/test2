package murach.utils;

public class DbConfiguration {

    public static final String HOST_NAME = "us-cdbr-east-04.cleardb.com";
    public static final String DB_NAME = "heroku_1c11f491448b1cd";
    public static final String DB_PORT = "3306";
    public static final String USER_NAME = "b23e1ada7923d9";
    public static final String PASSWORD = "dd49b115";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final int DB_MIN_CONNECTIONS = 2;
    public static final int DB_MAX_CONNECTIONS = 4;
    // jdbc:mysql://hostname:port/dbname
    public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME+"?autoReconnect=true";

    private DbConfiguration() {
        super();
    }
}