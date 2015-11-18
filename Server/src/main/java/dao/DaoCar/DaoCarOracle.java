package dao.DaoCar;

import dao.DaoConnectionManager;
import model.Car;

import java.sql.*;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarOracle  implements DaoInterfaceCar {

    PreparedStatement addCarPreparedStatement;
    PreparedStatement deleteColorPreparedStatement;
    PreparedStatement updateColorPreparedStatement;
    //PreparedStatement getAllColorPreparedStatement;

    public DaoCarOracle(){
        loadPrepareStatement();
    }

    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addCarPreparedStatement = connection.prepareStatement("insert into Car (carID, carModelID, carLocationID, transmissionID, carBodyStyleID, colorID, year, price) VALUES (null, ?,?,?,?,?,?,?)");

            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteColorPreparedStatement = connection.prepareStatement("");
            updateColorPreparedStatement = connection.prepareStatement("");
            */

            //getAllColorPreparedStatement = connection.prepareStatement("Select * from Color");
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void addCar(Car car) {
        try {
            System.out.println("allo");
            addCarPreparedStatement.setInt(1, car.getCarModelID());
            addCarPreparedStatement.setInt(2, car.getCarLocationID());
            addCarPreparedStatement.setInt(3, car.getTransmissionID());
            addCarPreparedStatement.setInt(4, car.getCarBodyStyleID());
            addCarPreparedStatement.setInt(5, car.getColorID());
            addCarPreparedStatement.setInt(6, car.getYear());
            addCarPreparedStatement.setDouble(7, car.getPrice());

            addCarPreparedStatement.executeUpdate();
            addCarPreparedStatement.getConnection().commit();


            /*ResultSet generatedKeysID = addCompagnyPreparedStatement.getGeneratedKeys();

            if(generatedKeysID.next())
            {
                int carID = generatedKeysID.getInt(1);
                System.out.println(carID);
                carCompany.setCompanyID(carID);
                //carCompany.setCompanyID((int) generatedKeysID.getLong(1));
                //System.out.println("blabla" + generatedKeysID.getLong(1));
            }
            */
            //carCompany.setCompanyID(id);
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void deleteCar(Car car) {

    }

    public void updateCar(Car car) {

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
            System.out.println("Car");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }
    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }
}
