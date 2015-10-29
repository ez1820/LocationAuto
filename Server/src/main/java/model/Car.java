package model;

/**
 * Created by admin on 2015-10-08.
 */
public class Car {
    private int carID;
    private int carModelID;
    private int carColorID;
    private int carBodyStyleID;
    private int year;
    private int colorID;
    private float price;
    private String model;


    public Car() {

    }
    public Car(int carID, int carModelID, int carColorID, int carBodyStyleID, int year, int colorID, float price, String model) {
        this.carID = carID;
        this.carModelID = carModelID;
        this.carColorID = carColorID;
        this.carBodyStyleID = carBodyStyleID;
        this.year = year;
        this.colorID = colorID;
        this.price = price;
        this.model = model;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(int carModelID) {
        this.carModelID = carModelID;
    }

    public int getCarColorID() {
        return carColorID;
    }

    public void setCarColorID(int carColorID) {
        this.carColorID = carColorID;
    }

    public int getCarBodyStyleID() {
        return carBodyStyleID;
    }

    public void setCarBodyStyleID(int carBodyStyleID) {
        this.carBodyStyleID = carBodyStyleID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
