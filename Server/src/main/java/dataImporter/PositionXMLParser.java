package dataImporter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
/**
 * Created by EdgarsonRomeus on 15-11-15.
 */
public class PositionXMLParser {

    public static void main(String[] argv){
        ClassLoader classloader = CarJsonParser.class.getClassLoader();
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
                System.out.println(element.getAttribute("user"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }





}
