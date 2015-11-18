package dataImporter;

import controller.NodeController;
import model.Node;

import java.util.List;

/**
 * Created by admin on 2015-11-17.
 */
public class NodeImporter {
    public static void main(String[] argv){

        NodeOsmParser nodeParser = new NodeOsmParser();

        List<Node> nodeList = nodeParser.getNodeList();
        //List<CarModel> carsModel = carParser.carDumpParser();

        for(Node node : nodeList)
        {
            System.out.println("pos en X: " + node.getLatX() + "  pos en Y: " + node.getLonY() + "   Id du node: " + node.getNodeNumber());
        }


        NodeController.getInstance().insertNode(nodeList);
        //CarController.getInstance().insertCarsModels(carsModel);

    }

}
