package model;

import org.json.simple.JSONObject;

/**
 * Created by admin on 2015-10-08.
 */
public class CarModel {

    private int carModelID;
    private CarCompany carCompany;
    private String modelName;

    public CarModel() {

    }

    public CarModel(int carModelID, CarCompany carCompany, String modelName) {
        this.carModelID = carModelID;
        this.carCompany = carCompany;
        this.modelName = modelName;

    }

    public int getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(int carModelID) {
        this.carModelID = carModelID;
    }

    public CarCompany getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(CarCompany carCompany) {
        this.carCompany = carCompany;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
