package dataImporter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EdgarsonRomeus on 15-11-15.
 */
public class NodeOsmParser {


    public List<model.Node> getNodeList()
    {
        List<model.Node> positionNodeList = new ArrayList<model.Node>();
        ClassLoader classloader = NodeOsmParser.class.getClassLoader();

        try {


            File file =  new File(classloader.getResource("PositionMAP.osm").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("node");


            for (int temp = 0; temp < nodes.getLength(); temp++) {
                Node node = nodes.item(temp);
                Element element = (Element) node;

                model.Node nodeElement = new model.Node();
                nodeElement.setLatX(Float.parseFloat(element.getAttribute("lat")));
                nodeElement.setLonY(Float.parseFloat(element.getAttribute("lon")));

                nodeElement.setNodeNumber(Long.parseLong(element.getAttribute("id")));
                //nodeElement.setNodeNumber(Integer.parseInt(element.getAttribute("id")));

                positionNodeList.add(nodeElement);
                //System.out.println("pos en X: " + element.getAttribute("lat") + "  pos en Y: " +element.getAttribute("lon") + "   Id du node: " + element.getAttribute("id"));



            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return positionNodeList;
    }





}
