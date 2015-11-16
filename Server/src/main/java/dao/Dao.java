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
import dao.DaoNode.DaoInterfaceNode ;

/**
 * Created by admin on 2015-10-12.
 */
public class Dao implements DaoInterface{
    private static Dao instance = null;
    private DaoInterfaceModel daoModel = null;
    private DaoInterfaceCompany daoCompany = null;
    private DaoInterfaceColor daoColor = null;
    private DaoInterfaceBodyStyle daoBodyStyle = null;
    private DaoInterfaceTransmission daoTransmission = null;
    private DaoInterfaceLocation daoLocation = null;
    private DaoInterfaceCustomer daoCustomer = null;
    private DaoInterfaceReservation daoReservation = null;
    private DaoInterfaceCar daoCar = null;
    private DaoInterfaceNode daoNode = null ;


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
        if (daoModel == null){
            createDaoModel();
        }
        return daoModel;
    }

    private synchronized void createDaoModel() {
        if (daoModel == null){
            daoModel = (DaoInterfaceModel) getObjectFromClassName(AppConfig.DAO_MODEL);
        }
    }


    public DaoInterfaceCompany getDaoCompany() {
        if(daoCompany == null){
            createDaoCompany();
        }
        return daoCompany;
    }

    private synchronized void createDaoCompany() {
        if (daoCompany == null){
            daoCompany = (DaoInterfaceCompany) getObjectFromClassName(AppConfig.DAO_COMPANY);
        }
    }

    public DaoInterfaceColor getDaoColor() {
        if(daoColor == null)
        {
            createDaoColor();
        }
        return daoColor;
    }

    private synchronized void createDaoColor() {
        if(daoColor == null)
        {
            daoColor = (DaoInterfaceColor) getObjectFromClassName(AppConfig.DAO_COLOR);
        }
    }

    public DaoInterfaceBodyStyle getDaoBodyStyle() {
        if(daoBodyStyle == null)
        {
            createDaoBodyStyle();
        }

        return daoBodyStyle;
    }

    private synchronized void  createDaoBodyStyle() {
        if(daoBodyStyle == null)
        {
            daoBodyStyle = (DaoInterfaceBodyStyle) getObjectFromClassName(AppConfig.DAO_BODYSTYLE);
        }
    }

    public DaoInterfaceTransmission getDaoTransmission()
    {
        if(daoTransmission ==  null)
        {
            createDaoTransmission();
        }
        return daoTransmission;
    }

    private synchronized void createDaoTransmission() {
        if(daoTransmission == null)
        {
            daoTransmission = (DaoInterfaceTransmission) getObjectFromClassName(AppConfig.DAO_TRANSMISSION);
        }

    }

    public DaoInterfaceLocation getDaoLocation() {
        if(daoLocation == null)
        {
            createDaoLocation();
        }
        return daoLocation;
    }

    private synchronized void createDaoLocation() {
        if(daoLocation == null)
        {
            daoLocation = (DaoInterfaceLocation) getObjectFromClassName(AppConfig.DAO_LOCATION);
        }
    }

    public DaoInterfaceCustomer getDaoCustomer() {
        if(daoCustomer == null)
        {
            createDaoCustomer();
        }
        return daoCustomer;
    }

    private synchronized void createDaoCustomer() {
        if(daoCustomer == null)
        {
            daoCustomer = (DaoInterfaceCustomer) getObjectFromClassName(AppConfig.DAO_CUSTOMER);
        }
    }

    public DaoInterfaceCar getDaoCar() {
        if(daoCar == null)
        {
            createDaoCar();
        }
        return daoCar;
    }

    private synchronized void createDaoCar()
    {
        if(daoCar == null)
        {
            daoCar = (DaoInterfaceCar) getObjectFromClassName(AppConfig.DAO_CAR);
        }
    }

    public DaoInterfaceReservation getDaoReservation() {
        if(daoReservation ==  null)
        {
            createDaoReservation();
        }
        return daoReservation;
    }

    private synchronized void createDaoReservation() {
        if(daoReservation ==  null)
        {
            daoReservation = (DaoInterfaceReservation) getObjectFromClassName(AppConfig.DAO_RESERVATION);
        }
    }

    // ************
    public DaoInterfaceNode getDaoNode()
    {
        if(daoNode ==  null)
        {
            createDaoNode();
        }
        return daoNode;
    }

    private synchronized void createDaoNode() {
        if(daoNode == null)
        {
            daoNode = (DaoInterfaceNode) getObjectFromClassName(AppConfig.DAO_NODE);
        }

    }

    // ************


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
