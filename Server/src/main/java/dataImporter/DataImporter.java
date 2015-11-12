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
    public static List<Customer> getListCustmer()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        List<String> customerFistName = new ArrayList<String>();
        List<String> customerlastName = new ArrayList<String>();

        customerFistName.add("");
        customerFistName.add("");
        customerFistName.add("");

        return customerList;
    }
}
