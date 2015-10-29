package model;

/**
 * Created by admin on 2015-10-08.
 */
public class CarCompany {


    private int companyID;
    private String companyName;

    public CarCompany() {


    }


    public CarCompany(int companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;

    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
