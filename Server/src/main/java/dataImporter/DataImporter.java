package dataImporter;

import controller.CarController;
import model.*;
import org.json.simple.parser.ParseException;

import javax.xml.stream.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by admin on 2015-11-05.
 */
public class DataImporter {
    private List<Color> carColor;
    public static void main(String[] args) throws IOException, ParseException {
        //CarJsonParser carParser = new CarJsonParser();
        //List<CarModel> carsModel = carParser.carDumpParser();

        //CarController.getInstance().insertCarsModels(carsModel);

        /*add the colors of the cars*/
        //List<Color> carColor = getListColor();




        //CarController.getInstance().insertColor(carColor);

        /*add the bodyStyle*/
        //List<CarBodyStyle> bodyStyleList = getListBodyStyle();


        //CarController.getInstance().insertBodyStyle(bodyStyleList);


        //add transmission
        List<Transmission> transmissionList = getListTransmission();
        CarController.getInstance().insertTransmission(transmissionList);

        //add customer
        //List<Customer> customerList = getListCustomer();
        //CarController.getInstance().insertCustomer(customerList);

        //add location
        //List<CarLocation> locationList = getListLocation();
        //CarController.getInstance().insertLocation(locationList);




    }

    public static List<Color> getListColor()
    {
        List<Color> colorList = new ArrayList<Color>();


        List<String> colorName = new ArrayList<String>();

        colorName.add("White");
        colorName.add("Black");
        colorName.add("Blue");
        colorName.add("Green");
        colorName.add("Red");
        colorName.add("Gray");
        colorName.add("darkBlue");


        for(int i = 0;i<colorName.size();i++)
        {
            Color color = new Color();
            color.setColorName(colorName.get(i));
            System.out.println("id :" + i + " nom couleur: " + color.getColorName());
            colorList.add(color);

        }
        return colorList;
    }
    public static List<CarBodyStyle> getListBodyStyle()
    {
        List<CarBodyStyle> bodyStyleList = new ArrayList<CarBodyStyle>();


        List<String> bodyStyle = new ArrayList<String>();

        bodyStyle.add("Berline");
        bodyStyle.add("Couper");
        bodyStyle.add("SUV");
        bodyStyle.add("Fourgonette");
        bodyStyle.add("Decapotable");

        for(int i = 0;i<bodyStyle.size();i++)
        {
            CarBodyStyle carBodyStyle = new CarBodyStyle();
            carBodyStyle.setBodyStyle(bodyStyle.get(i));
            System.out.println("id :" + i + " nom bodystyle: " + carBodyStyle.getBodyStyle());
            bodyStyleList.add(carBodyStyle);

        }
        return bodyStyleList;
    }


    public static List<Transmission> getListTransmission()
    {
        List<Transmission> transmissionList = new ArrayList<Transmission>();


        List<String> transmission = new ArrayList<String>();

        transmission.add("Automatique");
        transmission.add("Manuelle");


        for(int i = 0;i<transmission.size();i++)
        {
            Transmission carTransmission = new Transmission();
            carTransmission.setTransmissionName(transmission.get(i));
            transmissionList.add(carTransmission);
            System.out.println("id :" + i + " nom Transmission: " + carTransmission.getTransmissionName());
        }


        return transmissionList;
    }
    public static List<Customer> getListCustomer()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        List<String> customerFistName = new ArrayList<String>();
        List<String> customerLastName = new ArrayList<String>();

        customerFistName.add("Alain");
        customerFistName.add("Pascale");
        customerFistName.add("Bob");


        customerLastName.add("Beaudry");
        customerLastName.add("Lafontaine");
        customerLastName.add("Dupuis");


        for(int i = 0;i<customerFistName.size();i++)
        {
            Customer customer = new Customer();
            customer.setFirstName(customerFistName.get(i));
            customer.setLastName(customerLastName.get(i));
            customerList.add(customer);
            System.out.println("id :" + i + " nom customer: " + customerList.get(i).getFirstName() + " " + customerList.get(i).getLastName());
        }


        return customerList;
    }

    public static List<CarLocation> getListLocation()
    {
        List<CarLocation> locationList = new ArrayList<CarLocation>();
        List<Float> locationX = new ArrayList<Float>();
        List<Float> locationY = new ArrayList<Float>();

        locationX.add((float) 45.494542);
        locationY.add((float) -73.562398);

        for(int i = 0;i<locationX.size();i++)
        {
            CarLocation location = new CarLocation();
            location.setLocationX(locationX.get(i));
            location.setLocationY(locationY.get(i));
            locationList.add(location);
            System.out.println("id :" + i + " location en x: " + locationList.get(i).getLocationX() + " location en Y:" + locationList.get(i).getLocationY());
        }


        return locationList;
    }
    public static List<Car> carList()
    {
        List<Car> carList = new ArrayList<Car>();

        List<CarModel> carModel = new ArrayList<CarModel>();

        List<CarLocation> carLocation =  new ArrayList<CarLocation>();

        List<String> year = new ArrayList<String>();

        List<Double> price = new ArrayList<Double>();

        List<Transmission> transmission = new ArrayList<Transmission>();

        List<CarBodyStyle> carBodyStyle = new ArrayList<CarBodyStyle>();

        List<Color> color = new ArrayList<Color>();



        return carList;
    }

    public static List<CarModel> getAllModelList()
    {
        List<CarModel> modelList;

        modelList = CarController.getInstance().getAllModels();

        return modelList;

    }

    public static List<Transmission> getAllTransmission()
    {
        List<Transmission> transmissionList = new ArrayList<Transmission>();

        //transmissionList = CarController.getInstance().getAllTransmissions();

        return transmissionList;
    }
}
