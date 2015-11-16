package dao.DaoNode;

import model.Node;


/**
 * Created by EdgarsonRomeus on 15-11-15.
 */
public interface DaoInterfaceNode {

    public void addNode(Node node);
    public void deleteNode(Node node);
    public void updateNode(Node node);
    public void showTableContent();

}
