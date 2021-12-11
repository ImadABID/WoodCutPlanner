package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

// import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;
// import org.xml.sax.SAXException;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Writeable;

// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.transform.OutputKeys;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerException;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
// import java.io.File;
// import java.io.IOException;
import java.util.ArrayList;

public class SVGWriter implements Writer{

     public void write(ArrayList<Writeable> cuts, String path) {
         try {
//        //Document doc = new Document("decoupes.xml");
//        //doc.save("decoupes.svg", SaveFormat.Svg);
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document doc = builder.parse(path);  //decoupes.xml
//
//        Id client_id = new Id(), supplier_id = new Id(), board_id = new Id(), panel_id = new Id();
//        //int panel_length, panel_width, board_length, board_width;
//        int x, y;
//
//        NodeList decoupes = doc.getElementsByTagName(tagName);
//        for (int i=0; i<decoupes.getLength(); i++){
//            Node decoupe = decoupes.item(i);
//            NodeList clients = decoupe.getChildNodes();
//            for (int j=0; j< clients.getLength(); j++){
//                Node client = clients.item(j);
//                Element c = (Element) client;
//                String c_id = c.getAttribute("id");
//                String board = c.getAttribute("planche");
//                client_id.value = Integer.parseInt(c_id);
//                board_id.value = Integer.parseInt(board);
//
//                NodeList suppliers = doc.getChildNodes();
//                for (int k=0; k< suppliers.getLength();k++){
//                    Node supplier = suppliers.item(j);
//                    Element s = (Element) supplier;
//                    String s_id = s.getAttribute("id");
//                    String panel = s.getAttribute("panneau");
//                    supplier_id.value = Integer.parseInt(s_id);
//                    panel_id.value = Integer.parseInt(panel);
//                }
//
//                NodeList positions = doc.getChildNodes();
//                for (int ii=0; ii< positions.getLength();ii++){
//                    Node position = positions.item(ii);
//                    Element pos = (Element) position;
//                    String x_str = pos.getAttribute("x");
//                    String y_str = pos.getAttribute("y");
//                    x = Integer.parseInt(x_str);
//                    y = Integer.parseInt(y_str);
//                }
//            }
//            //construction de n fichier svg pour n decoupes
//            //panel_length =
//
//        }
//
//        Transformer t = TransformerFactory.newInstance().newTransformer();
//        t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
//                "http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd");
//        t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 20000802//EN");
//        t.setOutputProperty(OutputKeys.INDENT, "yes");
//        t.setOutputProperty(OutputKeys.METHOD, "xml");
//        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//
//        DOMSource source = new DOMSource(doc);
//        StreamResult resultat = new StreamResult(new File("decoupes.svg"));
//
//        t.transform(source, resultat);


         }catch(Exception e){
             System.out.println(e);
         }
     }
}
