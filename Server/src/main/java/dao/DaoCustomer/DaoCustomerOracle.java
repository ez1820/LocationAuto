package dao.DaoCustomer;

import dao.DaoConnectionManager;
import model.Customer;

import java.sql.*;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCustomerOracle implements DaoInterfaceCustomer {

    PreparedStatement addCustomerPreparedStatement;
    PreparedStatement deleteCustomerPreparedStatement;
    PreparedStatement updateCustomerPreparedStatement;

    public DaoCustomerOracle ()
    {
        loadPreparedStatement();
    }

    private void loadPreparedStatement() {
        Connection connection = getConnection();
        try {

            addCustomerPreparedStatement = connection.prepareStatement("insert into Customer (customerID, firstName, lastName) VALUES (null, ?,?)");
            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteTransmissionPreparedStatement = connection.prepareStatement("");
            updateTransmissionPreparedStatement = connection.prepareStatement("");
            */
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }


    public void addCustomer(Customer customer)
    {
        try {

            addCustomerPreparedStatement.setString(1, customer.getFirstName());
            addCustomerPreparedStatement.setString(2, customer.getLastName());
            //TODO: trouver le bon ID
            //addCompagnyPreparedStatement.executeUpdate();
            addCustomerPreparedStatement.executeUpdate();
            addCustomerPreparedStatement.getConnection().commit();

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

    public void deleteCustomer(Customer Customer) {

    }

    public void updateCustomer(Customer Customer) {

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
        System.out.println("Customer");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.print("prob resultat query");
    }
}

    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }
}
