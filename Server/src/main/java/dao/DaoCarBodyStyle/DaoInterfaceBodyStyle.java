package dao.DaoCarBodyStyle;

import model.CarBodyStyle;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceBodyStyle {

    public void addBodyStyle(CarBodyStyle carBodyStyle);
    public void deleteBodyStyle(CarBodyStyle carBodyStyle);
    public void updateBodyStyle(CarBodyStyle carBodyStyle);
    public void showTableContent();
}
