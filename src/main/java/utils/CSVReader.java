package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import userdefinedobject.SinglePoint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private File in = new File("./csv/2017-12-north-yorkshire-stop-and-search.csv");

    public void CSVReader() {
    }

    public List<SinglePoint> recordfromCSV() throws FileNotFoundException {


        List<SinglePoint> recordinserted = new ArrayList<SinglePoint>();
        FileReader readeCSV ;

        try {
            readeCSV = new FileReader(in);
            System.out.println(in.getName());
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(readeCSV);
            for (CSVRecord record : records) {
                recordinserted.add(new SinglePoint(record.get("Longitude") , record.get("Latitude"), record.get("Date").substring(0,10)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordinserted;
    }



}


