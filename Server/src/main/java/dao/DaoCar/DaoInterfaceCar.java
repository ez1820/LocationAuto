package dao.DaoCar;

import model.Car;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceCar {

    public void addCar(Car car);
    public void deleteCar(Car car);
    public void updateCar(Car car);
    public void showTableContent();

}
