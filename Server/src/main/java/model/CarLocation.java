package model;

/**
 * Created by admin on 2015-10-08.
 */

public class CarLocation {

    private int carLocationID;
    private float locationX;
    private float locationY;


    public CarLocation(){

    }
    public CarLocation(int carLocationID, float locationX, float locationY) {
        this.carLocationID = carLocationID;
        this.locationX = locationX;
        this.locationY = locationY;
    }





    public int getCarLocationID() {
        return carLocationID;
    }

    public void setCarLocationID(int carLocationID) {
        this.carLocationID = carLocationID;
    }

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }


}
