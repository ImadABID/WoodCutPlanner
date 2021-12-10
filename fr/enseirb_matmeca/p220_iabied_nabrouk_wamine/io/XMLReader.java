package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.*;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class XMLReader implements Reader {


    static public ArrayList<? extends WoodPiece> read(String path) {
        try {
            ArrayList<WoodPiece> wood = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document info = builder.parse(path);
            String tagName = "client";
            NodeList infoList = info.getElementsByTagName("client");
            if (infoList.getLength() == 0) {
                tagName = "fournisseur";
                infoList = info.getElementsByTagName("fournisseur");
            }
            for (int i = 0; i < infoList.getLength(); i++) {
                Node inf = infoList.item(i);
                Element elt = (Element) inf;
                Id actorId = new Id();
                actorId.setId(elt.getAttribute("id"));             //get client or supplier id
                NodeList boardsList = inf.getChildNodes();
                for (int j = 0; j < boardsList.getLength(); j++) {
                    Node panel = boardsList.item(j);
                    if (panel.getNodeType() == Node.ELEMENT_NODE) {

                        Element p = (Element) panel;

                        Id woodId = new Id();
                        woodId.setId(p.getAttribute("id"));   //get board or panel id
                        Number number = new Number();
                        number.setNumber(p.getAttribute("nombre"));    //get board or panel number
                        Deadline date = new Deadline();
                        date.setDeadline(p.getAttribute("date"));              //get board or panel date
                        Price price = new Price();
                        price.setPrice(p.getAttribute("prix"));                  //get board or panel price
                        Rectangle rect = null;
                        NodeList dimList = panel.getChildNodes();
                        for (int k = 0; k < dimList.getLength(); k++) {
                            Node dim = dimList.item(k);
                            if (dim.getNodeType() == Node.ELEMENT_NODE) {
                                Element d = (Element) dim;
                                rect = new Rectangle(new Point(0, 0), 0, 0);
                                rect.setLength(d.getAttribute("L"));      //get board or panel length
                                rect.setWidth(d.getAttribute("l"));          //get board or panel width

                            }
                        }

                        ArrayList<IsValid> listV = new ArrayList<>();
                        listV.add(actorId);
                        listV.add(woodId);
                        listV.add(number);
                        listV.add(price);
                        listV.add(date);
                        listV.add(rect);

                        boolean valid = true;
                        for (int kk = 0; kk < listV.size(); kk++) {
                            try {
                                listV.get(kk).isValid();

                            } catch (IllegalArgumentException e) {
                                valid = false;
                            }

                        }
                        if (valid == false) {
                            System.out.println(tagName + " " + actorId.getId() + " wood " + woodId.getId() + " not selected");
                            for (int kk = 0; kk < listV.size(); kk++) {
                                try {
                                    listV.get(kk).isValid();
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                        rect = new Rectangle(new Point(0, 0), rect.getLength(), rect.getWidth());
                        if (valid) {
                            if (tagName == "client") {
                                for (int wood_index = 0; wood_index < number.getNumber(); wood_index++) {
                                    wood.add(new Board(actorId, woodId, new Id(wood_index), number, rect, date, price));
                                }
                            }
                            if (tagName == "fournisseur") {
                                for (int wood_index = 0; wood_index < number.getNumber(); wood_index++) {
                                    wood.add(new Panel(actorId, woodId, new Id(wood_index), number, rect, date, price));
                                }
                            }
                        }
                    }
                }

            }
            return wood;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
