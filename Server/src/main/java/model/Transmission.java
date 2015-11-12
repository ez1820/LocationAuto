package model;

/**
 * Created by admin on 2015-10-08.
 */
public class Transmission {

    private int transmissionID;
    private String transmissionName;

    public String getTransmissionName() {
        return transmissionName;
    }

    public void setTransmissionName(String transmissionName) {
        this.transmissionName = transmissionName;
    }

    public int getTransmissionID() {
        return transmissionID;
    }

    public void setTransmissionID(int transmissionID) {
        this.transmissionID = transmissionID;
    }

    public Transmission()
    {

    }
    public Transmission(int transmissionID, String transmissionName) {
        this.transmissionID = transmissionID;
        this.transmissionName = transmissionName;
    }


}
