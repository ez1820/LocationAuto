package dao;

import java.sql.SQLException;

/**
 * Created by admin on 2015-10-16.
 */
public class TestConnectionMain {



    public static void main(String[] args){

        ConnectionTest test;
        try {
            test = new ConnectionTest();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
