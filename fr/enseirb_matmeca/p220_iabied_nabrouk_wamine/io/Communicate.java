package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Communicate implements isValid{

    // Input

    static public ArrayList<WoodPiece> readFromXML(String path, String tagName) throws ParserConfigurationException, IOException, SAXException {
        List<WoodPiece> wood = new ArrayList<WoodPiece>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document info = builder.parse(path);
        NodeList infoList = info.getElementsByTagName(tagName);
        for(int i = 0; i<infoList.getLength(); i++){
            Node inf = infoList.item(i);
            Element elt = (Element) inf;
            String id1 = elt.getAttribute("id");             //get client or supplier id
            int actor_id = Integer.parseInt(id1);
            NodeList boardsList = inf.getChildNodes();
            for(int j = 0; j < boardsList.getLength(); j++){
                Node panel = boardsList.item(j);
                if (panel.getNodeType() == Node.ELEMENT_NODE){
                    Element p = (Element) panel;
                    String id2 = p.getAttribute("id");   //get board or panel id
                    int panel_id = Integer.parseInt(id2);
                    String number = p.getAttribute("nombre");    //get board or panel number
                    int Number = Integer.parseInt(number);
                    String date = p.getAttribute("date");              //get board or panel date
                    String price = p.getAttribute("prix");                  //get board or panel price
                    float Price = Float.parseFloat(price);
                    NodeList dimList = panel.getChildNodes();
                    for(int k = 0; k < dimList.getLength(); k++){
                        Node dim = dimList.item(k);
                        if (dim.getNodeType() == Node.ELEMENT_NODE){
                            Element d = (Element) dim;
                            String length = d.getAttribute("L");      //get board or panel length
                            String width = d.getAttribute("l");             //get board or panel width
                            float L = Float.parseFloat(length);
                            float l = Float.parseFloat(width);
                            WoodPiece w;
                            Point point = new Point();
                            Rectangle rect = new Rectangle(point, L, l);
                            if (tagName == "client"){
                                wood.add(new Board(actor_id, panel_id, panel_id, Number, rect, date, Price));
                            }

                            if (tagName == "fournisseur") {
                                wood.add(new Panel(actor_id, panel_id, panel_id, Number, rect, date, Price));
                            }
                            //System.out.println("id " + id1 + " : " + "planche " + panel_id + " nombre " + number + " date " + date + " prix " + price + " longueur " + length + " largeur " + width);
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < wood.size(); i++)
            System.out.println(wood.get(i).getTypeId());
        return (ArrayList<WoodPiece>) wood;
    }



    // Output

    static public void generateCutsXML(List<Cut> cuts){

    }

    static public void generateCutsSVG(List<Cut> cuts){

    }

}
