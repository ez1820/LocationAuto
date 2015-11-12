package model;

/**
 * Created by admin on 2015-10-08.
 */
public class CarBodyStyle {

    private int carBodyStyleID;
    private String bodyStyle;

    public CarBodyStyle (){}
    public CarBodyStyle(int carBodyStyleID, String bodyStyle) {
        this.carBodyStyleID = carBodyStyleID;
        this.bodyStyle = bodyStyle;
    }


    //comment Test
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getCarBodyStyleID() {
        return carBodyStyleID;
    }

    public void setCarBodyStyleID(int carBodyStyleID) {
        this.carBodyStyleID = carBodyStyleID;
    }






}
