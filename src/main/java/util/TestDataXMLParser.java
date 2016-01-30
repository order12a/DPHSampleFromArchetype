package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.yandex.qatools.properties.PropertyLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static util.PropertyLoader.*;

public class TestDataXMLParser {

    static Document doc;
    static NodeList nList;

    public static void readTargetFile(String path) throws ParserConfigurationException, SAXException, IOException {
        FileSystem fileSystem = FileSystems.getDefault();
        String sep = fileSystem.getSeparator();
        String newPath = "";

        try {
            newPath = path.replaceAll("\\\\", sep);
        } catch (Exception e) {
        }

        try {
            newPath.replaceAll("\\/", sep);
        } catch (Exception e2) {
        }

        File fXmlFile = new File(newPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(fXmlFile);
    }

    public static void parseProvider(String provider) {
        doc.getDocumentElement().normalize();
        if (isProduction()) {
            String prodProvider = provider + "_prod";
            nList = doc.getElementsByTagName(prodProvider);
        } else {
            nList = doc.getElementsByTagName(provider);
        }
        System.out.println("----------testData------------------");
    }

    public static boolean isProduction(){
        String environment = null;
        try {
            environment = loadProperty("environment");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(environment.equals("production")){
            return true;
        }else{
            return false;
        }
    }

    public static String getData(String key) {

        String value = "";
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                value = eElement.getElementsByTagName(key).item(0).getTextContent();
                System.out.println(key + ": " + value);
            }
        }

        return value;
    }
}
