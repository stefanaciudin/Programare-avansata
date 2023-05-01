package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class DatabaseManager - used to manage the connection to the database
 */

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/music_library";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setAutoCommit(true);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
//        config.setConnectionTimeout(60000);
//        config.setIdleTimeout(900000);
//        config.setMaxLifetime(1800000);
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public static void deleteAll(String tableName) throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        try (Statement stmt = conn.createStatement()) {
            String query = "DELETE FROM " + tableName;
            stmt.executeUpdate(query);
            conn.setAutoCommit(false);
            conn.commit();
        }
    }
}


