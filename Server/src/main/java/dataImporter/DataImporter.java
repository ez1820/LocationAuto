package dataImporter;

import controller.CarController;
import model.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-11-05.
 */
public class DataImporter {
    private List<Color> carColor;
    private final static int NB_CAR = 10;

    public static void main(String[] args) throws IOException, ParseException {
       // CarJsonParser carParser = new CarJsonParser();
        //List<CarModel> carsModel = carParser.carDumpParser();

        //CarController.getInstance().insertCarsModels(carsModel);

        /*add the colors of the cars*/
     /*   List<Color> carColor = getListColor();

        CarController.getInstance().insertColor(carColor);*/

        /*add the bodyStyle*/
        //List<CarBodyStyle> bodyStyleList = getListBodyStyle();


        //CarController.getInstance().insertBodyStyle(bodyStyleList);


        //add transmission
        //List<Transmission> transmissionList = getListTransmission();
        //CarController.getInstance().insertTransmission(transmissionList);

        //add customer
        //List<Customer> customerList = getListCustomer();
        //CarController.getInstance().insertCustomer(customerList);

        //add location
        //List<CarLocation> locationList = getListLocation();
        //CarController.getInstance().insertLocation(locationList);

        //add Car
        //List<Car> carList = getCarList();
        //CarController.getInstance().insertCar(carList);

       /* List<Transmission> tansmissionList= getAllTransmission();


        System.out.println("size list: " + tansmissionList.size());

*/

        //List<CarBodyStyle> bodyStyleList = getAllBodyStyle();
        //List<CarLocation> bodyStyleList = getAllCarLocation();

        //List<Color> colorList = getAllColor();

        //List<CarModel> modelList = getAllModelList();

        List<Car> carList = getCarList(NB_CAR);
        CarController.getInstance().insertCar(carList);

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

    public static List<Car> getCarList(int nbCar)
    {
        List<Car> carList = new ArrayList<Car>();
        List<CarModel> carModelList = getAllModelList();
        List<CarLocation> carLocationList = getAllCarLocation();
        List<Integer> yearList = getAllYearList();
        List<Double> priceList = getAllPriceList();
        List<Transmission> transmissionList = getAllTransmission();
        List<CarBodyStyle> carBodyStyleList = getAllBodyStyle();
        List<Color> colorList = getAllColor();

        Car car = null;
        for(int i=0; i<nbCar;i++)
        {
            car = new Car();

            /*insert un carModelID*/
            int indexCarModel = (int) (Math.random() * carModelList.size());
            car.setCarModelID(carModelList.get(indexCarModel).getCarModelID());

            /*insert un carLocationID*/
            int indexCarLocation = (int) (Math.random() * carLocationList.size());
            car.setCarLocationID(carLocationList.get(indexCarLocation).getCarLocationID());


            /*insert le yearID*/
            int indexYear = (int) (Math.random() * yearList.size());
            car.setYear(yearList.get(indexYear));

            /*insert priceID*/

            int indexPrice = (int) (Math.random() * priceList.size());
            car.setPrice(priceList.get(indexPrice));

            /*insert tranmissionID*/
            int indexTransmission = (int) (Math.random() * transmissionList.size());
            car.setTransmissionID(transmissionList.get(indexTransmission).getTransmissionID());

            /*insert bodyStyleID*/
            int indexBodyStyle = (int) (Math.random() * carBodyStyleList.size());
            car.setCarBodyStyleID(carBodyStyleList.get(indexBodyStyle).getCarBodyStyleID());

            /*insert colorID*/
            int indexColor = (int) (Math.random() * colorList.size());
            car.setColorID(colorList.get(indexColor).getColorID());

            carList.add(car);
        }

        return carList;


        /*int indexCarModel = (int) (Math.random() * carModelList.size());
        car.setCarModelID(carModelList.get(indexCarModel).getCarModelID());

        System.out.println("index: " + indexCarModel + "   model: " + carModelList.get(indexCarModel).getModelName() + "  Id du model: " + carModelList.get(indexCarModel).getCarModelID());*/

       /* int indexCarLocation = (int) (Math.random() * carLocationList.size());
        car.setCarLocationID(carLocationList.get(indexCarLocation).getCarLocationID());
        System.out.println( carLocationList.get(indexCarLocation).getCarLocationID() +"/"+ carLocationList.get(indexCarLocation).getLocationX() +"/"+ carLocationList.get(indexCarLocation).getLocationY() );
*/

        /*int indexYear = (int) (Math.random() * yearList.size());
        car.setYear(yearList.get(indexCarModel));

        System.out.println("index: " + indexYear + "   asd " + year.get(indexYear));*/

        /*int indexPrice = (int) (Math.random() * priceList.size());
        //car.setPrice(priceList.get(indexPrice));

        System.out.println("index: " + indexPrice + " price" + priceList.get(indexPrice));*/


        /*int indexTransmission = (int) (Math.random() * transmissionList.size());
        //car.setTransmissionID(transmissionList.get(indexTransmission).getTransmissionID());
        System.out.println("index: " + indexTransmission + " transmission Name: " + transmissionList.get(indexTransmission).getTransmissionName() + "/id trans: " + transmissionList.get(indexTransmission).getTransmissionID());
        */

   /*     int indexBodyStyle = (int) (Math.random() * carBodyStyleList.size());
        //car.setCarBodyStyleID(carBodyStyleList.get(indexBodyStyle).getCarBodyStyleID());

        System.out.println("index: " + indexBodyStyle + " index bodystyle: " + carBodyStyleList.get(indexBodyStyle).getCarBodyStyleID() + "  name : " + carBodyStyleList.get(indexBodyStyle).getBodyStyle());

*/
        /*int indexColor = (int) (Math.random() * colorList.size());
        //car.setCarID(colorList.get(indexColor).getColorID());

        System.out.println("index: " + indexColor + " index price :" + colorList.get(indexColor).getColorID() + "  name color: " + colorList.get(indexColor).getColorName());*/



    }

    public static List<Integer> getAllYearList()
    {
        List<Integer> yearList =  new ArrayList<Integer>();

        yearList.add(2007);
        yearList.add(2008);
        yearList.add(2009);
        yearList.add(2010);
        yearList.add(2011);
        yearList.add(2012);
        yearList.add(2013);
        yearList.add(2014);
        yearList.add(2015);

        return yearList;
    }

    public static List<Double> getAllPriceList()
    {
        List<Double> priceList = new ArrayList<Double>();

        priceList.add(35.95);
        priceList.add(40.25);
        priceList.add(32.60);
        priceList.add(38.05);

        return priceList;
    }

    public static List<CarModel> getAllModelList()
    {
        List<CarModel> modelList;

        modelList = CarController.getInstance().getAllModels();

        return modelList;

    }

    public static List<Transmission> getAllTransmission()
    {
        List<Transmission> transmissionList;

        transmissionList = CarController.getInstance().getAllTranmission();

        return transmissionList;
    }
    public static List<CarBodyStyle> getAllBodyStyle()
    {
        List<CarBodyStyle> bodyStyleList;

        bodyStyleList = CarController.getInstance().getAllBodyStyle();

        return bodyStyleList;
    }
    public static List<Color> getAllColor()
    {
        List<Color> colorList;

        colorList = CarController.getInstance().getAllColor();

        return colorList;
    }
    public static List<CarLocation> getAllCarLocation()
    {
        List<CarLocation> carLocationList;

        carLocationList = CarController.getInstance().getAllLocation();

        return carLocationList;
    }



}
