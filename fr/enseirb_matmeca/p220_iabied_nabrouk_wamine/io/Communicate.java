package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import java.util.ArrayList;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;

public class Communicate {

    // Input

     static public List<WoodPiece> readClients(String path, String tagName) throws ParserConfigurationException, IOException, SAXException {
        List<WoodPiece> wood = new ArrayList<WoodPiece>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document info = builder.parse(path);
        NodeList infoList = info.getElementsByTagName(tagName);
        for(int i = 0; i<infoList.getLength(); i++){
            Node inf = infoList.item(i);
            Element elt = (Element) inf;
            String id = elt.getAttribute("id");
            NodeList boardsList = inf.getChildNodes();
            for(int j = 0; j < boardsList.getLength(); j++){
                Node panel = boardsList.item(j);
                if (panel.getNodeType() == Node.ELEMENT_NODE){
                    Element p = (Element) panel;
                    String panel_id = p.getAttribute("id");
                    String number = p.getAttribute("nombre");
                    String date = p.getAttribute("date");
                    String price = p.getAttribute("prix");
                    float Price = Float.parseFloat(price);
                    NodeList dimList = panel.getChildNodes();
                    for(int k = 0; k < dimList.getLength(); k++){
                        Node dim = dimList.item(k);
                        if (dim.getNodeType() == Node.ELEMENT_NODE){
                            Element d = (Element) dim;
                            String length = d.getAttribute("L");
                            String width = d.getAttribute("l");
                            float L = Float.parseFloat(length);
                            float l = Float.parseFloat(width);
                            if (L < 0 || l < 0){
                                //throw new IllegalArgumentException("Dimension is defined for non-negative numbers");
                                System.out.println("Dimension is defined for non-negative numbers");
                            }
                            if (L <= l){
                                //throw new IllegalArgumentException("Length must be greater than width");
                                System.out.println("Length must be greater than width");
                            }

                            Rectangle rect = new Rectangle(new Point(), L, l);
                            WoodPiece w;
                            if (tagName == "client"){
                                w = new Board( id, panel_id, number, rect, date, price);

                            }
                            System.out.println("id " + id + " : " + "planche " + panel_id + " nombre " + number + " date " + date + " prix " + price + " longueur " + length + " largeur " + width);
                        }
                    }
                }
            }
        }
        return wood;
    }

    // Output

    static public void generateCutsXML(List<Cut> cuts){

    }

    static public void generateCutsSVG(List<Cut> cuts){

    }

}
