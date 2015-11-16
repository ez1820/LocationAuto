package controller;

import dao.Dao;
import model.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by EdgarsonRomeus on 15-11-13.
 */


public class NodeController {


    public static NodeController  instance  = null ;

    public static NodeController getInstance() {


        if (instance == null ){

            createNodeController();
        }
        return instance ;
    }

    public synchronized static void createNodeController () {

        if(instance == null){

            instance = new NodeController();
        }

    }

 private NodeController () {}

    public void insertNode(List<Node> nodeList)
    {
        System.out.println("Inserting node");
        int i=1;
        for (Node c : nodeList)
        {
            insertNode(c);
            System.out.println(i + " node inserted / " + c.getNodeID()+ "" + c.getNodeNumber()+ "" +c.getLatX()+ "" + c.getLonY()+ "" + c.getTag() );
            i++;
        }
    }

    private void insertNode(Node node)
    {
        if(node.getNodeID() == 0)
        {

            Dao.getInstance().getDaoNode().addNode(node);

        }
    }
}
