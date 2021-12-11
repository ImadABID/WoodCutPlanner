package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Writable;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class XMLWriter implements Writer{

    // rmq: ne pas mettre le path en dur
    public void write(ArrayList<Writable> cuts, String path){
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // racine
            Document doc = builder.newDocument();
            Element racine = doc.createElement("decoupes");
            doc.appendChild(racine);

            ArrayList<String> fields;

            for (Writable cut : cuts) {

                fields = cut.getFields();

                // decoupes
                Element decoupe = doc.createElement("decoupe");
                racine.appendChild(decoupe);

                // client
                Element client = doc.createElement("client");
                decoupe.appendChild(client);

                // attributs de client id
                Attr attr = doc.createAttribute("id");
                attr.setValue(fields.get(0));
                client.setAttributeNode(attr);

                // attributs de commande planche
                attr  = doc.createAttribute("planche");
                attr.setValue(fields.get(1));
                client.setAttributeNode(attr);

                // fournisseur
                Element fournisseur = doc.createElement("fournisseur");
                decoupe.appendChild(fournisseur);

                // attributs de commande id
                attr = doc.createAttribute("id");
                attr.setValue(fields.get(2));
                fournisseur.setAttributeNode(attr);

                // attributs de commande panneau
                attr = doc.createAttribute("panneau");
                attr.setValue(fields.get(3));
                fournisseur.setAttributeNode(attr);

                // position
                Element position = doc.createElement("position");
                decoupe.appendChild(position);

                // attributs de position x
                attr = doc.createAttribute("x");
                attr.setValue(fields.get(4));
                position.setAttributeNode(attr);

                // attributs de position y
                attr = doc.createAttribute("y");
                attr.setValue(fields.get(5));
                position.setAttributeNode(attr);

            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(new File(path));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, resultat);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
