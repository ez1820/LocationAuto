import model.Car;
import model.CarCompany;
import model.CarModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-10-09.
 */
public class CarParser {

    public  List<CarModel> carDumpParser() throws IOException, ParseException {

        ClassLoader classloader = CarParser.class.getClassLoader();
        File file =  new File(classloader.getResource("exempleTest.json").getFile());
       // BD_dump_car
                //exempleTest
        JSONParser parser =  new JSONParser();


        JSONArray carArrayList = (JSONArray) parser.parse(new FileReader(file));

        CarCompany carCompany = null;
        CarModel carModel = null;

        List <CarModel> carModelList = new ArrayList<CarModel>();;

        for(Object object : carArrayList)

        {
            JSONObject carDump = (JSONObject) object;

            for (int i = 0; i < carArrayList.size(); i++)
                {
                    carCompany = new CarCompany();
                    carCompany.setCompanyName((String) carDump.get("title"));
                    System.out.print(" Marque : " + carCompany.getCompanyName());
                    System.out.print("    ");



                    ArrayList<JSONObject> modelList = (ArrayList<JSONObject>) carDump.get("models");

                    for (int j=0; j < modelList.size(); j++)
                    {
                        carModel = new CarModel();
                        carModel.setModelName((String) modelList.get(j).get("title"));
                        carModel.setCarCompany(carCompany);
                        carModelList.add(carModel);
                        System.out.print("model : " + carModel.getModelName());
                        System.out.print("    ");
                    }
                }

        }
        return carModelList;
    }
}
