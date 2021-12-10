package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class XMLWriter implements Writer{

    // rmq: ne pas mettre le path en dur
     public void write(ArrayList<Cut> cuts, String path){
         try {
             Board client_b;
             Panel supplier_p;
             Cut cut;

             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();

             // racine
             Document doc = builder.newDocument();
             Element racine = doc.createElement("decoupes");
             doc.appendChild(racine);

             for (Cut value : cuts) {
                 cut = value;
                 client_b = cut.getBoard();
                 supplier_p = cut.getPanel();
                 // decoupes
                 Element decoupe = doc.createElement("decoupe");
                 racine.appendChild(decoupe);

                 // client
                 Element client = doc.createElement("client");
                 decoupe.appendChild(client);

                 // attributs de client id
                 Attr attr_id = doc.createAttribute("id");
                 attr_id.setValue(String.valueOf(client_b.getActorId().getId()));
                 client.setAttributeNode(attr_id);

                 // attributs de commande planche
                 Attr planche = doc.createAttribute("planche");
                 planche.setValue(String.valueOf(client_b.getTypeId().getId())); //?
                 client.setAttributeNode(planche);

                 // fournisseur
                 Element fournisseur = doc.createElement("fournisseur");
                 decoupe.appendChild(fournisseur);

                 // attributs de commande id
                 attr_id = doc.createAttribute("id");
                 attr_id.setValue(String.valueOf(supplier_p.getActorId().getId()));
                 fournisseur.setAttributeNode(attr_id);

                 // attributs de commande panneau
                 Attr panneau = doc.createAttribute("panneau");
                 panneau.setValue(String.valueOf(supplier_p.getTypeId().getId())); //?
                 fournisseur.setAttributeNode(panneau);

                 // position
                 Element position = doc.createElement("position");
                 decoupe.appendChild(position);

                 // attributs de position x
                 Attr x = doc.createAttribute("x");
                 x.setValue(String.valueOf(cut.getPosition().getX())); //?
                 position.setAttributeNode(x);

                 // attributs de position y
                 Attr y = doc.createAttribute("y");
                 y.setValue(String.valueOf(cut.getPosition().getY())); //?
                 position.setAttributeNode(y);

             }

             // write the content into xml file
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(doc);
             StreamResult resultat = new StreamResult(new File("decoupes.xml"));
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
             transformer.transform(source, resultat);

             // write the content into xml file
        /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File("decoupes.xml"));*/
             //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
             //transformer.transform(source, resultat);

             //SVG
//        XPathFactory sfactory = XPathFactory.newInstance();
//        XPath xpath = sfactory.newXPath();
//        String xpathQuery = "./svg";
//        XPathExpression exp = xpath.compile(xpathQuery);
//        Node svgNode = (Node) exp.evaluate(doc, XPathConstants.NODE);


         }catch(Exception e){
             System.out.println(e);
         }
     }
}
