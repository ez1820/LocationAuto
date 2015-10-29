import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by admin on 2015-10-12.
 */
public class DataImporter {
    public static void main(String[] args) throws IOException, ParseException {
        CarParser carParser = new CarParser();
        carParser.carDumpParser();
    }

}
