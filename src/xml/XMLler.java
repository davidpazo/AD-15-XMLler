package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class XMLler {

    static String ruta = "/home/oracle/Desktop/Pruebas/autores.xml";

    public static void main(String[] args) {
        XMLler xl = new XMLler();
        xl.Leer();
    }

    public void Leer() {
        try {
            FileInputStream fis = new FileInputStream(ruta);

            XMLStreamReader xml = XMLInputFactory.newInstance().createXMLStreamReader(fis);

            while (xml.hasNext()) {
                xml.next();

                if (xml.getEventType() == XMLStreamConstants.START_ELEMENT) {

                    String al = xml.getAttributeLocalName(0);
                    String av = xml.getAttributeValue(0);
                    if (al != null && av != null) {
                        System.out.print("<" + xml.getLocalName() + " " + al + "=" + '"' + av + '"' + ">\n");
                    } else {
                        System.out.print("<" + xml.getLocalName() + ">\n");
                    }
                } else if (xml.getEventType() == XMLStreamConstants.CHARACTERS) {
                    System.out.print(xml.getText());
                } else if (xml.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    System.out.print("</" + xml.getLocalName() + ">\n");
                }
            }

            xml.close();

        } catch (FileNotFoundException | XMLStreamException ex) {
                System.out.println("Exception de Stream, \nFichero no encontrado" + ex);
        }

    }

}
