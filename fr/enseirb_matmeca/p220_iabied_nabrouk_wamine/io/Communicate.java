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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Communicate{

    // Input

    static public ArrayList<WoodPiece> readFromXML(String path, String tagName) throws ParserConfigurationException, IOException, SAXException, ParseException {
        List<WoodPiece> wood = new ArrayList<WoodPiece>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document info = builder.parse(path);
        NodeList infoList = info.getElementsByTagName(tagName);
        for(int i = 0; i<infoList.getLength(); i++){
            Node inf = infoList.item(i);
            Element elt = (Element) inf;
            ActorId actorId = new ActorId();
            String id1 = elt.getAttribute("id");             //get client or supplier id
            actorId.value = Integer.parseInt(id1);
            NodeList boardsList = inf.getChildNodes();
            for(int j = 0; j < boardsList.getLength(); j++){
                Node panel = boardsList.item(j);
                if (panel.getNodeType() == Node.ELEMENT_NODE){
                    Element p = (Element) panel;
                    WoodId woodId = new WoodId();
                    String id2 = p.getAttribute("id");   //get board or panel id
                    woodId.value = Integer.parseInt(id2);
                    Number number = new Number();
                    String num = p.getAttribute("nombre");    //get board or panel number
                    number.value = Integer.parseInt(num);
                    Date date = new Date();
                    date.date = p.getAttribute("date");              //get board or panel date
                    Price price = new Price();
                    price.value_1 = p.getAttribute("prix");                  //get board or panel price
                    price.value_2 = Float.parseFloat(price.value_1);
                    NodeList dimList = panel.getChildNodes();
                    for(int k = 0; k < dimList.getLength(); k++){
                        Node dim = dimList.item(k);
                        if (dim.getNodeType() == Node.ELEMENT_NODE){
                            Element d = (Element) dim;
                            Dimension dimension = new Dimension();
                            String length = d.getAttribute("L");      //get board or panel length
                            String width = d.getAttribute("l");             //get board or panel width
                            dimension.length = Float.parseFloat(length);
                            dimension.width = Float.parseFloat(width);

                            Point point = new Point();
                            Rectangle rect = new Rectangle(point, dimension.length, dimension.width );

                            ArrayList<IsValid> listV = new ArrayList<>();
                            listV.add(actorId);
                            listV.add(woodId);
                            listV.add(number);
                            listV.add(price);
                            listV.add(date);
                            listV.add(dimension);

                            boolean valid = true;
                            for (int kk = 0; kk< listV.size();kk++)
                            {
                                if(!(listV.get(kk).isValid()))
                                {
                                    valid = false;
                                }
                            }
                            if (valid == true) {
                                if (tagName == "client") {
                                    wood.add(new Board(actorId.value, woodId.value, woodId.value, number.value, rect, date.date, price.value_2));
                                }
                                if (tagName == "fournisseur") {
                                    wood.add(new Panel(actorId.value, woodId.value, woodId.value, number.value, rect, date.date, price.value_2));
                                }
                            }
                        }
                    }
                }
            }
        }
        return (ArrayList<WoodPiece>) wood;
    }


    // Output

    static public void generateCutsXML(List<Cut> cuts){

    }

    static public void generateCutsSVG(List<Cut> cuts){

    }
}
