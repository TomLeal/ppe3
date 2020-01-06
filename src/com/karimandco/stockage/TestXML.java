package com.karimandco.stockage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author t.leal
 */
public class TestXML {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fileXML = new File("test.xml");

            Document xml = builder.parse(fileXML);

            Element root = xml.getDocumentElement();
            
            //https://openclassrooms.com/fr/courses/2654406-java-et-le-xml/2686109-a-la-decouverte-de-dom
            System.out.println(root.getNodeName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
