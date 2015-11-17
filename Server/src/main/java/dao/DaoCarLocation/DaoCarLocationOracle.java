package dao.DaoCarLocation;

import dao.DaoConnectionManager;
import model.CarBodyStyle;
import model.CarLocation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarLocationOracle implements DaoInterfaceLocation {
    PreparedStatement addLocationPreparedStatement;
    PreparedStatement deleteLocationPreparedStatement;
    PreparedStatement updateLocationPreparedStatement;
    PreparedStatement getAllLocationPreparedStatement;

    public DaoCarLocationOracle()
    {
        loadPrepareStatement();
    }

    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addLocationPreparedStatement = connection.prepareStatement("insert into CarLocation (carLocationID, locationX, locationY) VALUES (null, ?,?)");
            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteBodyStylePreparedStatement = connection.prepareStatement("");
            updateBodyStylePreparedStatement = connection.prepareStatement("");
            */
            getAllLocationPreparedStatement = connection.prepareStatement("Select * from carLocation");
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void addLocation(CarLocation carLocation) {
        try {

            addLocationPreparedStatement.setFloat(1, carLocation.getLocationX());
            addLocationPreparedStatement.setFloat(2, carLocation.getLocationY());

            //TODO: trouver le bon ID
            //addCompagnyPreparedStatement.executeUpdate();
            addLocationPreparedStatement.executeUpdate();

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

    public List<CarLocation> getAllLocation() {
        List<CarLocation> locationList = new ArrayList<CarLocation>();

        try {
            getAllLocationPreparedStatement.executeQuery();

            ResultSet result = getAllLocationPreparedStatement.getResultSet();

            while (result.next())

            {
                CarLocation location = new CarLocation();

                int carLocationID = result.getInt(1);
                float carLocationX = result.getFloat(2);
                float carLocationY = result.getFloat(3);


                System.out.println("ID car location: " + carLocationID + "   location X : " + carLocationX + "   Location Y: " + carLocationY);

                location.setCarLocationID(carLocationID);
                location.setLocationX(carLocationX);
                location.setLocationY(carLocationY);

                locationList.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locationList;
    }

    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
