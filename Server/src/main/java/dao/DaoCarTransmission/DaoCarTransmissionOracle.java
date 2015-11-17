package dao.DaoCarTransmission;

import dao.DaoCarTransmission.DaoInterfaceTransmission;
import dao.DaoConnectionManager;
import model.CarCompany;
import model.CarModel;
import model.Transmission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarTransmissionOracle implements DaoInterfaceTransmission {
    PreparedStatement addTransmissionPreparedStatement;
    PreparedStatement deleteTransmissionPreparedStatement;
    PreparedStatement updateTransmissionPreparedStatement;
    PreparedStatement getAllTransmissionsPreparedStatement;

    public DaoCarTransmissionOracle()
    {
        loadPrepareStatement();
    }
    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addTransmissionPreparedStatement = connection.prepareStatement("insert into Transmission (transmissionID, transmissionName) VALUES (null, ?)");
            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteTransmissionPreparedStatement = connection.prepareStatement("");
            updateTransmissionPreparedStatement = connection.prepareStatement("");
            */
            getAllTransmissionsPreparedStatement = connection.prepareStatement("select * from transmission");
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void addTransmission(Transmission transmission)
    {
        try {

            addTransmissionPreparedStatement.setString(1, transmission.getTransmissionName());
            //TODO: trouver le bon ID
            //addCompagnyPreparedStatement.executeUpdate();
            addTransmissionPreparedStatement.executeUpdate();
            //ResultSet result = getAllTransmissionsPreparedStatement.getResultSet();
            //getConnection().commit();
            addTransmissionPreparedStatement.getConnection().commit();



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

    public void deleteTransmission(Transmission carTransmission) {

    }

    public void updateTransmission(Transmission carTransmission) {

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
            System.out.println("Transmission");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }

    public List<Transmission> getAllTransmissions() {
        List<Transmission> TransmissionList = new ArrayList<Transmission>();

        try {

            getAllTransmissionsPreparedStatement.executeQuery();

            ResultSet result = getAllTransmissionsPreparedStatement.getResultSet();

            System.out.println("asdasd  " + result.getFetchSize());

            while(result.next())
            {

                Transmission transmission = new Transmission();

                int transmissionID = result.getInt(1);
                String transmissionName = result.getString(2);


                transmission.setTransmissionID(transmissionID);
                transmission.setTransmissionName(transmissionName);

                System.out.println("transmission ID :  " + transmissionID + "  transmission name: " + transmissionName);

                TransmissionList.add(transmission);


            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TransmissionList;
    }

    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
