package dao.DaoCarLocation;

import model.CarLocation;

import java.util.List;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceLocation {


    public void addLocation(CarLocation carLocation);
    public void deleteLocation(CarLocation carLocation);
    public void updateLocation(CarLocation carLocation);
    public void showTableContent();
    public List<CarLocation> getAllLocation();

}
