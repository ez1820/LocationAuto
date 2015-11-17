package dao.DaoCarCompany;
import dao.DaoConnectionManager;
import model.CarCompany;
import oracle.sql.ROWID;

import java.sql.*;
import java.util.Objects;

/**
 * Created by admin on 2015-10-12.
 */
public class DaoCarCompanyOracle implements DaoInterfaceCompany {
    PreparedStatement addCompagnyPreparedStatement;
    PreparedStatement deleteCompagnyPreparedStatement;
    PreparedStatement updateCompagnyPreparedStatement;

    public DaoCarCompanyOracle(){
        loadPrepareStatement();
    }

    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addCompagnyPreparedStatement = connection.prepareStatement("insert into CarCompany (companyID, companyName) VALUES (null, ?)", new String[]{"CompanyId"});

            /*
            deleteCompagnyPreparedStatement = connection.prepareStatement("");
            updateCompagnyPreparedStatement = connection.prepareStatement("");
            */
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void addCompany(CarCompany carCompany) {
        try {


            addCompagnyPreparedStatement.setString(1, carCompany.getCompanyName());
            //TODO: trouver le bon ID
            //addCompagnyPreparedStatement.executeUpdate();
            addCompagnyPreparedStatement.executeUpdate();



            ResultSet generatedKeysID = addCompagnyPreparedStatement.getGeneratedKeys();

            if(generatedKeysID.next())
            {
                int carID = generatedKeysID.getInt(1);
                System.out.println(carID);
                carCompany.setCompanyID(carID);
                //carCompany.setCompanyID((int) generatedKeysID.getLong(1));
                //System.out.println("blabla" + generatedKeysID.getLong(1));
            }
            addCompagnyPreparedStatement.getConnection().commit();
            //carCompany.setCompanyID(id);
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void deleteCompany(CarCompany carCompany) {

    }

    public void updateCompany(CarCompany carCompany) {

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
            System.out.println("Company");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }
    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
