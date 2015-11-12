package dao;

import config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 2015-10-24.
 */
public class DaoConnectionManager {
    Connection oracleConnection = null;

    private static DaoConnectionManager instance = null;

    public static DaoConnectionManager getInstance(){
        if (instance == null){
            createDao();
        }
        return instance;
    }

    private DaoConnectionManager(){}

    public synchronized static void createDao(){
        if (instance == null){
            instance = new DaoConnectionManager();
        }
    }

    public Connection getOracleConnection(){
        if (oracleConnection == null){
            createOracleConnection();
        }
        return oracleConnection;
    }

    private synchronized void createOracleConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            oracleConnection = DriverManager.getConnection(AppConfig.ORACLE_URL, AppConfig.ORACLE_USERNAME, AppConfig.ORACLE_PASSWORD);
            oracleConnection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            oracleConnection.close();
            oracleConnection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
