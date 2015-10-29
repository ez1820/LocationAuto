import dao.Dao;

/**
 * Created by admin on 2015-10-24.
 */
public class main {
    public static void main(String[] argv){

        Dao.getInstance().getDaoCustomer().showTableContent();

    }

}
