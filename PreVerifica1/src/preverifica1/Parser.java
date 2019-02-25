package preverifica1;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List link;

    public Parser() {
        link = new ArrayList();
    }

    public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        String doc;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                doc = getTextValue((Element) nodelist.item(i), "td");
                
//if(element.hasAttribute(info))
//info = getLink(element);

                link.add(doc);
            }
        }
        return link;
    }

    /*
    private String GetLink(Element element){
        return element.getAttribute("href");
    }
     */
    private Docente getDocente(Element element) {
        Docente doc;
        String numero = getTextValue(element, "numero");
        String cognome = getTextValue(element, "cognome");
        String giorno = getTextValue(element, "giorno");
        String ora = getTextValue(element, "ora");
        doc = new Docente(numero, cognome, giorno, ora);
        return doc;
    }

    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String tmp = "";
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);

        if (nodelist != null && nodelist.getLength() > 0) {
            link.add(element);

            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                if (element != null && element.getFirstChild() != null) {
                    tmp += element.getFirstChild().getNodeValue() + " ";
                }
            }
        }
        return tmp;
    }

    // restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }

    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }

}
