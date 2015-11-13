package model;

/**
 * Created by admin on 2015-10-08.
 */
public class CarReservation {

    private int carReservationID;
    private int carID;

    private int clientID;
    private float reservationPrice;
    private String reservationStatus;

    public CarReservation(int carReservationID, int carID, int clientID, float reservationPrice, String reservationStatus) {
        this.carReservationID = carReservationID;
        this.carID = carID;
        this.clientID = clientID;
        this.reservationPrice = reservationPrice;
        this.reservationStatus = reservationStatus;
    }

    public int getCarReservationID() {
        return carReservationID;
    }

    public void setCarReservationID(int carReservationID) {
        this.carReservationID = carReservationID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public float getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(float reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

}
