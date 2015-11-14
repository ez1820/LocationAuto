package model;

/**
 * Created by EdgarsonRomeus on 15-11-13.
 */


/**
 On a node you have:
 Nodeid
 NodeNumb
 Lat
 Lon

 */


public class Node {

    private int nodeID;
    private int NodeNumber ;
    private float latX ;
    private float latY ;
    private String tag ;

    public Node(){


    }

    public Node(int nodeID,int NodeNumber, float latX, float latY, String tag) {
        this.nodeID = nodeID;
        this.NodeNumber = NodeNumber ;
        this.latX = latX ;
        this.latY = latY ;
        this.tag = tag ;
    }

//get the actual node ID

    public int getNodeID() {

        return nodeID ;
    }

// set the actual node ID

    public void setNodeID(int nodeID){

        this.nodeID = nodeID ;
    }

// get the node unique number

    public int getNodeNumber () {

        return NodeNumber ;
    }

    // Set the node unique number

    public void setNodeNumber (int NodeNumber){

        this.NodeNumber = NodeNumber ;
    }


//get the actual latX

    public float getLatX() {

        return latX ;
    }

// set the actual latY

    public void setLatx ( float latY){

        this.latY = latY ;
    }

//get the actual node tag

    public String getTag() {

        return tag ;
    }

    // set the actual node tag

    public void setTag (String tag){

        this.tag = tag ;
    }

}
