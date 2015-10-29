package dao;

import config.AppConfig;
import dao.DaoCarBodyStyle.DaoInterfaceBodyStyle;
import dao.DaoCarColor.DaoInterfaceColor;
import dao.DaoCarCompany.DaoInterfaceCompany;
import dao.DaoCarLocation.DaoInterfaceLocation;
import dao.DaoCarModel.DaoInterfaceModel;
import dao.DaoCar.DaoInterfaceCar;
import dao.DaoCarReservation.DaoInterfaceReservation;
import dao.DaoCarTransmission.DaoInterfaceTransmission;
import dao.DaoCustomer.DaoInterfaceCustomer;

/**
 * Created by admin on 2015-10-12.
 */
public class Dao implements DaoInterface{
    private static Dao instance = null;

    public static Dao getInstance(){
        if (instance == null){
            createDao();
        }
        return instance;
    }

    public synchronized static void createDao(){
        if (instance == null){
            instance = new Dao();
        }
    }

    private Dao(){}

    public DaoInterfaceModel getDaoModel() {
        return (DaoInterfaceModel) getObjectFromClassName(AppConfig.DAO_MODEL);
    }

    public DaoInterfaceCompany getDaoCompany() {
        return (DaoInterfaceCompany) getObjectFromClassName(AppConfig.DAO_COMPANY);
    }

    public DaoInterfaceColor getDaoColor() {
        return (DaoInterfaceColor) getObjectFromClassName(AppConfig.DAO_COLOR);
    }

    public DaoInterfaceBodyStyle getDaoBodyStyle() {
        return (DaoInterfaceBodyStyle) getObjectFromClassName(AppConfig.DAO_BODYSTYLE);
    }

    public DaoInterfaceTransmission getDaoTransmission() {
        return (DaoInterfaceTransmission) getObjectFromClassName(AppConfig.DAO_TRANSMISSION);
    }

    public DaoInterfaceLocation getDaoLocation() {
        return (DaoInterfaceLocation) getObjectFromClassName(AppConfig.DAO_LOCATION);
    }

    public DaoInterfaceCustomer getDaoCustomer() {
        return (DaoInterfaceCustomer) getObjectFromClassName(AppConfig.DAO_CUSTOMER);
    }

    public DaoInterfaceCar getDaoCar() {
        return (DaoInterfaceCar) getObjectFromClassName(AppConfig.DAO_CAR);
    }

    public DaoInterfaceReservation getDaoReservation() {
        return (DaoInterfaceReservation) getObjectFromClassName(AppConfig.DAO_RESERVATION);
    }

    private Object getObjectFromClassName(String className){
        Object object = null;

        try {
            Class cls = Class.forName(className);
            object = cls.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        return object;
    }

}
