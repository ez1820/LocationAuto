package dao.DaoCarModel;

import dao.DaoConnectionManager;
import model.CarCompany;
import model.CarModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarModelOracle implements DaoInterfaceModel {

    PreparedStatement addModelPreparedStatement;
    PreparedStatement deleteModelPreparedStatement;
    PreparedStatement updateModelPreparedStatement;
    PreparedStatement getAllModelPreparedStatement;


    private int companyID;


    public DaoCarModelOracle(){
        loadPrepareStatement();
    }


    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {
            System.out.println("test");
            addModelPreparedStatement = connection.prepareStatement("insert into CarModel (carModelID, carCompanyID, modelName) VALUES (null, ?,?)", new String[]{"carmodelID","carCompanyID"});/*
            deleteModelPreparedStatement = connection.prepareStatement("");
            updateModelPreparedStatement = connection.prepareStatement("");*/
            getAllModelPreparedStatement = connection.prepareStatement("Select * from CarModel");
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }


    public void addModel(CarModel carModel) {

        try {

            addModelPreparedStatement.setInt(1, carModel.getCarCompany().getCompanyID());
            addModelPreparedStatement.setString(2, carModel.getModelName());
            //TODO: Trouver le bon ID
            addModelPreparedStatement.executeUpdate();
            ResultSet generatedKeysID = addModelPreparedStatement.getGeneratedKeys();

            if(generatedKeysID.next())
            {
                int companyID = generatedKeysID.getInt(1);
                int carModelID = generatedKeysID.getInt(2);

                System.out.println("Id de la compagnie / " + companyID);
                System.out.println("Id du modele inserer dans la compagnie /" + carModelID);

                carModel.setCarModelID(carModelID);
                //carCompany.setCompanyID((int) generatedKeysID.getLong(1));
                //System.out.println("blabla" + generatedKeysID.getLong(1));
            }
            addModelPreparedStatement.getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<CarModel> getAllModels() {


        List<CarModel> modelList = new ArrayList<CarModel>();

        try {

            getAllModelPreparedStatement.executeQuery();
            ResultSet result = getAllModelPreparedStatement.getResultSet();

            while(result.next())
            {



                CarCompany carCompany =  new CarCompany();
                CarModel carModel = new CarModel();
                int carModelID = result.getInt(1);
                int companyID = result.getInt(2);
                String modelName = result.getString(3);

                System.out.println("Id de la compagnie / " + companyID + "  Id du modele  dans la compagnie /" + carModelID + "  Model name: " + modelName);


                carCompany.setCompanyID(carModelID);
                carModel.setCarCompany(carCompany);
                carModel.setCarModelID(carModelID);
                carModel.setModelName(modelName);


                modelList.add(carModel);

                //carCompany.setCompanyID((int) generatedKeysID.getLong(1));
                //System.out.println("blabla" + generatedKeysID.getLong(1));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelList;
    }


    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }


}
