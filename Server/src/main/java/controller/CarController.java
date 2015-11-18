package controller;

import dao.Dao;
import model.*;

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
    public void insertCustomer(List<Customer> customerList)
    {
        System.out.println("Inserting Customer");
        int i=1;
        for (Customer c : customerList)
        {

            insertCustomer(c);
            System.out.println(i + " customer inserted / " + c.getFirstName() + "" + c.getLastName());
            i++;
        }
    }
    private void insertCustomer(Customer customer)
    {
        if(customer.getCustomerID() == 0)
        {
            Dao.getInstance().getDaoCustomer().addCustomer(customer);
        }

    }
    public void insertLocation(List<CarLocation> locationList)
    {
        System.out.println("Inserting location");
        int i=1;
        for (CarLocation c : locationList)
        {

            insertLocation(c);
            System.out.println(i + " location inserted / " + c.getLocationX() + "" + c.getLocationY());
            i++;
        }
    }

    private void insertLocation(CarLocation carLocation)
    {
        if(carLocation.getCarLocationID()==0)
        {
            Dao.getInstance().getDaoLocation().addLocation(carLocation);
        }
    }

    public void insertCar(List<Car> carList)
    {
        System.out.println("Inserting Car");
        int i=1;
        for (Car c : carList)
        {
            insertCar(c);
            i++;
        }
    }

    private void insertCar(Car car)
    {
        if(car.getCarID() == 0)
        {
            Dao.getInstance().getDaoCar().addCar(car);
        }
    }


    public List<CarModel> getAllModels()
    {
        List<CarModel> carModelList;

        carModelList = Dao.getInstance().getDaoModel().getAllModels();

        return carModelList;
    }
    public List<Transmission> getAllTranmission()
    {
        List<Transmission> carTransmissionList;

        carTransmissionList = Dao.getInstance().getDaoTransmission().getAllTransmissions();


        return carTransmissionList;
    }
    public List<CarBodyStyle> getAllBodyStyle()
    {
        List<CarBodyStyle> carBodyStyleList;

        carBodyStyleList = Dao.getInstance().getDaoBodyStyle().getAllBodyStyle();

        return carBodyStyleList;
    }

    public List<Color> getAllColor()
    {
        List<Color> colorList;

        colorList = Dao.getInstance().getDaoColor().getAllColor();

        return colorList;
    }
    public List<CarLocation> getAllLocation()
    {
        List<CarLocation> colorList;

        colorList = Dao.getInstance().getDaoLocation().getAllLocation();

        return colorList;
    }




}
