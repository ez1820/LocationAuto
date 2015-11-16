package dataImporter;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Node ;
/**
 * Created by EdgarsonRomeus on 15-11-15.
 */
public class PositionXMLParser {

    ClassLoader classloader = CarJsonParser.class.getClassLoader();
    File file =  new File(classloader.getResource("PositionMAP.osm").getFile());



}
