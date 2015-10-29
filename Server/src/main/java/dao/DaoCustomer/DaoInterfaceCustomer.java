package dao.DaoCustomer;

import model.Customer;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceCustomer {

    public void addCustomer(Customer Customer);
    public void deleteCustomer(Customer Customer);
    public void updateCustomer(Customer Customer);
    public void showTableContent();
}
