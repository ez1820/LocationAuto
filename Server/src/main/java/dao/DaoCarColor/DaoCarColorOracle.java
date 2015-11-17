package dao.DaoCarColor;

import dao.DaoCarColor.DaoInterfaceColor;
import dao.DaoConnectionManager;
import model.CarBodyStyle;
import model.CarCompany;
import model.Color;
import sun.org.mozilla.javascript.internal.ast.WhileLoop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-10-15.
 */
public class DaoCarColorOracle implements DaoInterfaceColor {



    PreparedStatement addColorPreparedStatement;
    PreparedStatement deleteColorPreparedStatement;
    PreparedStatement updateColorPreparedStatement;
    PreparedStatement getAllColorPreparedStatement;

    public DaoCarColorOracle(){
        loadPrepareStatement();
    }

    private void loadPrepareStatement() {
        Connection connection = getConnection();
        try {

            addColorPreparedStatement = connection.prepareStatement("insert into Color (colorID, colorName) VALUES (null, ?)");

            //ON DUPLICATE KEY UPDATE companyID=?, companyName=?
            /*
            deleteColorPreparedStatement = connection.prepareStatement("");
            updateColorPreparedStatement = connection.prepareStatement("");
            */

            getAllColorPreparedStatement = connection.prepareStatement("Select * from Color");
        } catch (SQLException e) {
            DaoConnectionManager.getInstance().closeConnection();
            e.printStackTrace();
        }
    }

    public void addColor(Color color)
    {
        try {

            addColorPreparedStatement.setString(1, color.getColorName());

            addColorPreparedStatement.executeUpdate();

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

    public void deleteColor(Color carColor) {

    }

    public void updateColor(Color carColor) {

    }

    public void showTableContent()
    {
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
            System.out.println("color");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("prob resultat query");
        }
    }

    public List<Color> getAllColor() {

        List<Color> colorList = new ArrayList<Color>();


        try {

            getAllColorPreparedStatement.executeQuery();

            ResultSet result = getAllColorPreparedStatement.getResultSet();


            while (result.next())
            {
                Color color = new Color();

                int colorID = result.getInt(1);
                String colorName = result.getString(2);



                color.setColorID(colorID);
                color.setColorName(colorName);

                colorList.add(color);
            }
            getAllColorPreparedStatement.getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return colorList;
    }

    private Connection getConnection(){
        return DaoConnectionManager.getInstance().getOracleConnection();
    }

}
