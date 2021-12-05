package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Deadline;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Id;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.IsValid;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Price;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.*;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Communicate{
    public Communicate() {
    }

    // Input

    static public ArrayList<? extends WoodPiece> readFromXML(String path, String tagName) throws ParserConfigurationException, IOException, SAXException {
        
        ArrayList<WoodPiece> wood = new ArrayList<>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document info = builder.parse(path);
        NodeList infoList = info.getElementsByTagName(tagName);
        for(int i = 0; i<infoList.getLength(); i++){
            Node inf = infoList.item(i);
            Element elt = (Element) inf;
            Id actorId = new Id();
            String id1 = elt.getAttribute("id");             //get client or supplier id
            actorId.value = Integer.parseInt(id1);
            NodeList boardsList = inf.getChildNodes();
            for(int j = 0; j < boardsList.getLength(); j++){
                Node panel = boardsList.item(j);
                if (panel.getNodeType() == Node.ELEMENT_NODE){

                    Element p = (Element) panel;

                    Id woodId = new Id();
                    String id2 = p.getAttribute("id");   //get board or panel id
                    woodId.value = Integer.parseInt(id2);

                    Number number = new Number();
                    String num = p.getAttribute("nombre");    //get board or panel number
                    number.value = Integer.parseInt(num);
                    
                    Deadline date = new Deadline();
                    date.date = p.getAttribute("date");              //get board or panel date
                    
                    Price price = new Price();
                    price.value_1 = p.getAttribute("prix");                  //get board or panel price
                    price.value_2 = Float.parseFloat(price.value_1);

                    Rectangle rect = null;
                    NodeList dimList = panel.getChildNodes();
                    for(int k = 0; k < dimList.getLength(); k++){
                        Node dim = dimList.item(k);
                        if (dim.getNodeType() == Node.ELEMENT_NODE){
                            Element d = (Element) dim;
                            
                            String length_str = d.getAttribute("L");      //get board or panel length
                            String width_str = d.getAttribute("l");          //get board or panel width

                            rect = new Rectangle(
                                new Point(0, 0),
                                Float.parseFloat(length_str),
                                Float.parseFloat(width_str)
                            );

                            break;

                        }
                    }

                    ArrayList<IsValid> listV = new ArrayList<>();
                    listV.add(actorId);
                    listV.add(woodId);
                    listV.add(number);
                    listV.add(rect);
                    listV.add(price);
                    listV.add(date);

                    boolean valid = true;
                    for (IsValid isValid : listV) {
                        if (isValid == null || !(isValid.isValid())) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        if (Objects.equals(tagName, "client")) {
                            for(int wood_index = 0; wood_index<number.value; wood_index++){
                                wood.add(new Board(actorId, woodId, new Id(wood_index), number, rect, date, price));
                            }
                        }
                        if (Objects.equals(tagName, "fournisseur")) {
                            for(int wood_index = 0; wood_index<number.value; wood_index++){
                                wood.add(new Panel(actorId, woodId, new Id(wood_index), number, rect, date, price));
                            }
                        }
                    }
                }
            }
        }
        
        return wood;
    }


    // Output

    static public void generateCutsXML(ArrayList<Cut> cuts) throws ParserConfigurationException, TransformerException {

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
            attr_id.setValue(String.valueOf(client_b.getActorId().value));
            client.setAttributeNode(attr_id);

            // attributs de commande planche
            Attr planche = doc.createAttribute("planche");
            planche.setValue(String.valueOf(client_b.getTypeId().value)); //?
            client.setAttributeNode(planche);

            // fournisseur
            Element fournisseur = doc.createElement("fournisseur");
            decoupe.appendChild(fournisseur);

            // attributs de commande id
            attr_id = doc.createAttribute("id");
            attr_id.setValue(String.valueOf(supplier_p.getActorId().value));
            fournisseur.setAttributeNode(attr_id);

            // attributs de commande panneau
            Attr panneau = doc.createAttribute("panneau");
            panneau.setValue(String.valueOf(supplier_p.getTypeId().value)); //?
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


    }

    static public void generateCutsSVG(ArrayList<Cut> cuts, String path, String tagName) throws IOException, SAXException, ParserConfigurationException, TransformerException {

        //Document doc = new Document("decoupes.xml");
        //doc.save("decoupes.svg", SaveFormat.Svg);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(path);  //decoupes.xml

        Id client_id = new Id(), supplier_id = new Id(), board_id = new Id(), panel_id = new Id();
        //int panel_length, panel_width, board_length, board_width;
        int x, y;

        NodeList decoupes = doc.getElementsByTagName(tagName);
        for (int i=0; i<decoupes.getLength(); i++){
            Node decoupe = decoupes.item(i);
            NodeList clients = decoupe.getChildNodes();
            for (int j=0; j< clients.getLength(); j++){
                Node client = clients.item(j);
                Element c = (Element) client;
                String c_id = c.getAttribute("id");
                String board = c.getAttribute("planche");
                client_id.value = Integer.parseInt(c_id);
                board_id.value = Integer.parseInt(board);

                NodeList suppliers = doc.getChildNodes();
                for (int k=0; k< suppliers.getLength();k++){
                    Node supplier = suppliers.item(j);
                    Element s = (Element) supplier;
                    String s_id = s.getAttribute("id");
                    String panel = s.getAttribute("panneau");
                    supplier_id.value = Integer.parseInt(s_id);
                    panel_id.value = Integer.parseInt(panel);
                }

                NodeList positions = doc.getChildNodes();
                for (int ii=0; ii< positions.getLength();ii++){
                    Node position = positions.item(ii);
                    Element pos = (Element) position;
                    String x_str = pos.getAttribute("x");
                    String y_str = pos.getAttribute("y");
                    x = Integer.parseInt(x_str);
                    y = Integer.parseInt(y_str);
                }
            }
            //construction de n fichier svg pour n decoupes
            //panel_length =

        }

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                "http://www.w3.org/TR/2000/CR-SVG-20000802/DTD/svg-20000802.dtd");
        t.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 20000802//EN");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File("decoupes.svg"));

        t.transform(source, resultat);


    }
}
