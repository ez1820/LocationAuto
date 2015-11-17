package model;

/**
 * Created by admin on 2015-10-08.
 */
public class Car {
    private int carID;
    private int carModelID;
    private int carBodyStyleID;
    private int year;
    private int colorID;
    private double price;
    private int carLocationID;
    private int transmissionID;


    public Car() {

    }
    public Car(int carID, int carModelID, int carBodyStyleID, int carLocationID, int year, int colorID, float price, int transmissionID) {
        this.carID = carID;
        this.carModelID = carModelID;
        this.carBodyStyleID = carBodyStyleID;
        this.carLocationID = carLocationID;
        this.year = year;
        this.colorID = colorID;
        this.price = price;
        this.transmissionID = transmissionID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCarLocationID() {
        return carLocationID;
    }

    public void setCarLocationID(int carLocationID) {
        this.carLocationID = carLocationID;
    }

    public int getTransmissionID() {
        return transmissionID;
    }

    public void setTransmissionID(int transmissionID) {
        this.transmissionID = transmissionID;
    }
}
