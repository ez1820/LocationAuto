package dao.DaoCarTransmission;

import model.Transmission;

import java.util.List;

/**
 * Created by admin on 2015-10-12.
 */
public interface DaoInterfaceTransmission {

    public void addTransmission(Transmission carTransmission);
    public void deleteTransmission(Transmission carTransmission);
    public void updateTransmission(Transmission carTransmission);
    public void showTableContent();
    public List<Transmission> getAllTransmissions();

}
