package dao.DaoCarLocation;

import dao.DaoConnectionManager;
import model.CarLocation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarLocationOracle implements DaoInterfaceLocation {


    public void addLocation(CarLocation carLocation) {

    }

    public void deleteLocation(CarLocation carLocation) {

    }

    public void updateLocation(CarLocation carLocation) {

    }

    public void showTableContent() {
        Connection connection = getConnection();

        /*
        REQUEST
         */
        //.commit() ou autocommit sur la connection   connection.setAutoCommit(true);

        Statement statement =  null;
        String query = "Select * from autoTest";

        try {
            statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            while (queryResult.next())
            {
                int carID = queryResult.getInt("CARID");
                String carMarque = queryResult.getString("CARMARQUE");
                System.out.println("ID de la voiture: " + carID + " Marque de la voiture: " + carMarque);
            }

            // Fermer la connexion une fois le traitement fini.
            connection.close();
            System.out.println("CarLocation");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }

    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
