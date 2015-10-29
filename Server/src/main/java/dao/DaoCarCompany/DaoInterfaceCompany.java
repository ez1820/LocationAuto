package dao.DaoCarCompany;

import model.CarCompany;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceCompany {

    public void addCompany(CarCompany carCompany);
    public void deleteCompany(CarCompany carCompany);
    public void updateCompany(CarCompany carCompany);
    public void showTableContent();

}
