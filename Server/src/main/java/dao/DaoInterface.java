package dao;

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
public interface DaoInterface {
    public DaoInterfaceModel getDaoModel();
    public DaoInterfaceCompany getDaoCompany();
    public DaoInterfaceColor getDaoColor();
    public DaoInterfaceBodyStyle getDaoBodyStyle();
    public DaoInterfaceTransmission getDaoTransmission();
    public DaoInterfaceLocation getDaoLocation();
    public DaoInterfaceCustomer getDaoCustomer();
    public DaoInterfaceCar getDaoCar();
    public DaoInterfaceReservation getDaoReservation();
}

