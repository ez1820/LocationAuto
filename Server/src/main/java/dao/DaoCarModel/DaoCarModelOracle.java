package dao.DaoCarModel;

import dao.DaoConnectionManager;
import model.CarModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarModelOracle implements DaoInterfaceModel {

    public void addModel(CarModel carModel) {
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


            // Fermer la connexion une fois le traitement fini.
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }


    }

    public void deleteModel(CarModel carModel) {

    }

    public void updateModel(CarModel carModel) {

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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }



    }


    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }


}
