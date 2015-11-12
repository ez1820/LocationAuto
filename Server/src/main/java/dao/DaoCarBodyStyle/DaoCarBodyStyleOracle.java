package dao.DaoCarBodyStyle;

import dao.DaoConnectionManager;
import model.CarBodyStyle;

import java.sql.*;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarBodyStyleOracle implements DaoInterfaceBodyStyle {
    PreparedStatement addBodyStylePreparedStatement;
    PreparedStatement deleteBodyStylePreparedStatement;
    PreparedStatement updateBodyStylePreparedStatement;

    public DaoCarBodyStyleOracle()
    {
        loadPrepareStatement();
    }


    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addBodyStylePreparedStatement = connection.prepareStatement("insert into CarBodyStyle (carBodyStyleID, bodyStyle) VALUES (null, ?)");

            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteBodyStylePreparedStatement = connection.prepareStatement("");
            updateBodyStylePreparedStatement = connection.prepareStatement("");
            */
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }
    public void addBodyStyle(CarBodyStyle carBodyStyle) {
        try {
            System.out.println("allo");
            System.out.println(carBodyStyle.getBodyStyle());
            System.out.println(addBodyStylePreparedStatement + "   asd");

            addBodyStylePreparedStatement.setString(1, carBodyStyle.getBodyStyle());
            //System.out.println(addBodyStylePreparedStatement);
            //TODO: trouver le bon ID

            addBodyStylePreparedStatement.executeUpdate();

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

    public void deleteBodyStyle(CarBodyStyle carBodyStyle) {

    }

    public void updateBodyStyle(CarBodyStyle carBodyStyle) {

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
            System.out.println("bodystyle");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }
    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
