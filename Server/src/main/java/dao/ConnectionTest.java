package dao;

import java.sql.*;

/**
 * Created by admin on 2015-10-16.
 */
public class ConnectionTest {

    private static final String ORACLE_URL = "jdbc:oracle:thin:@10.194.32.143:1521:GTI660";
    //big-data-2.logti.etsmtl.ca:1521
    //10.194.32.143
    //10.194.8.60
    private static final String ORACLE_USERNAME = "equipe35";
    private static final String ORACLE_PASSWORD = "BWFLNkYp";

    Connection connection;


    public ConnectionTest() throws ClassNotFoundException, SQLException {
        init();
    }

    private void init() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(ORACLE_URL, ORACLE_USERNAME, ORACLE_PASSWORD);
            //System.out.println(connection.isValid(10));
            System.out.println(connection);
            request(connection);

        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

    }

    public void request(Connection connection) {
        Statement statement = null;
        String query = "Select * from autoTest";

        try {
            statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            while (queryResult.next()) {
                System.out.println("asd" + queryResult);
                int carID = queryResult.getInt("CARID");
                String carMarque = queryResult.getString("CARMARQUE");
                System.out.println("ID de la voiture: " + carID + " Marque de la voiture: " + carMarque);


            }

            //System.out.println(queryResult);


        } catch (SQLException e) {
            System.out.println("Pas de statement");
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            //ResultSet queryResult =
        }

    /*
    analyse, conception, implementation == plus recherche-- travail au niveau conception- analyse recherche de chemin comprendre algo et expliuwer algo - pq ca pq meilleire solution simulation



    doc vision, etape a la lettre, les requis
    */

    }
}
