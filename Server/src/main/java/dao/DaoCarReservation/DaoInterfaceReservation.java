package dao.DaoCarReservation;

import model.CarReservation;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceReservation {

    public void addReservation(CarReservation carReservation);
    public void deleteReservation(CarReservation carReservation);
    public void updateReservation(CarReservation carReservation);
    public void showTableContent();
}
