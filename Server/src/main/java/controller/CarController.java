package controller;

import dao.Dao;
import model.CarBodyStyle;
import model.CarModel;
import model.Color;
import model.Transmission;

import java.util.List;

/**
 * Created by admin on 2015-11-05.
 */
public class CarController {

    private static CarController instance = null;

    public static CarController getInstance(){
        if (instance == null){
            createCarController();
        }
        return instance;
    }

    public synchronized static void createCarController(){
        if (instance == null){
            instance = new CarController();
        }
    }

    private CarController(){}

    public void insertCarsModels(List<CarModel> carModel) {
        System.out.println("Inserting cars");
        int i=1;
        for (CarModel c : carModel){
            insertCarModels(c);
            System.out.println(i + " car inserted / " + carModel.size());
            i++;
        }

    }

    private void insertCarModels(CarModel carModel) {
        if (carModel.getCarCompany().getCompanyID() == 0){
            Dao.getInstance().getDaoCompany().addCompany(carModel.getCarCompany());
        }
        Dao.getInstance().getDaoModel().addModel(carModel);
    }

    public void insertColor(List<Color> color)
    {
        System.out.println("Inserting colors");
        int i=1;
        for (Color c : color)
        {
            insertColor(c);
            System.out.println(i + " color inserted / " + c.getColorName());
            i++;
        }
    }
    private void insertColor(Color color)
    {
        if(color.getColorID() == 0)
        {
            Dao.getInstance().getDaoColor().addColor(color);
        }
    }
    public void insertBodyStyle(List<CarBodyStyle> bodyStyleList)
    {
        System.out.println("Inserting bodystyle");
        int i=1;
        for (CarBodyStyle c : bodyStyleList)
        {

            insertBodyStyle(c);
            System.out.println(i + " bodystyle inserted / " + c.getBodyStyle());
            i++;
        }
    }
    private void insertBodyStyle(CarBodyStyle bodyStyle)
    {
        if(bodyStyle.getCarBodyStyleID() == 0)
        {

            Dao.getInstance().getDaoBodyStyle().addBodyStyle(bodyStyle);

        }
    }
    public void insertTransmission(List<Transmission> transmissionList)
    {
        System.out.println("Inserting transmission");
        int i=1;
        for (Transmission c : transmissionList)
        {

            insertTransmission(c);
            System.out.println(i + " bodystyle inserted / " + c.getTransmissionName());
            i++;
        }
    }
    private void insertTransmission(Transmission transmission)
    {
        if(transmission.getTransmissionID() == 0)
        {

            Dao.getInstance().getDaoTransmission().addTransmission(transmission);

        }
    }
}
