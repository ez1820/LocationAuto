package dao.DaoCarModel;

import model.CarModel;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceModel {

    public void addModel(CarModel carModel);
    public void deleteModel(CarModel carModel);
    public void updateModel(CarModel carModel);
    public void showTableContent();

}
