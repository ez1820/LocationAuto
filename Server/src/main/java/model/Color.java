package model;

/**
 * Created by admin on 2015-10-08.
 */
public class Color {

    private int colorID;
    private String colorName;


    public Color(){}

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }



    public Color(int colorID, String colorName) {
        this.colorID = colorID;
        this.colorName = colorName;
    }


}
