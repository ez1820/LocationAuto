package dao.DaoCarColor;

import model.Color;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceColor {

    public void addColor(Color carColor);
    public void deleteColor(Color carColor);
    public void updateColor(Color carColor);
    public void showTableContent();
}
