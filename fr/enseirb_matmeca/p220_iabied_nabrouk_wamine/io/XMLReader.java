package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.BasicObject;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Readable;

class XMLReader implements Reader {


    public ArrayList<Readable> read(String path) {

        try {

            ArrayList<Readable> wood = new ArrayList<Readable>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document info = builder.parse(path);

            // getting tag name
            String tagName = "client";
            NodeList infoList = info.getElementsByTagName("client");
            if (infoList.getLength() == 0) {
                tagName = "fournisseur";
                infoList = info.getElementsByTagName("fournisseur");
            }

            // Declaring BasicObjects :
            BasicObject actorId;
            BasicObject woodId;
            BasicObject idInsideGroup;
            BasicObject nbrPiecesFromType;
            BasicObject polygon;
            BasicObject criticalDate;
            BasicObject price;

            // Declaring paramList
            ArrayList<String> paramList;

            for (int i = 0; i < infoList.getLength(); i++) {

                Node inf = infoList.item(i);
                Element elt = (Element) inf;
                
                // Get actor id
                paramList = new ArrayList<String>();
                paramList.add(elt.getAttribute("id"));
                actorId = BasicObject.buildBasicObject("Id", paramList);
                
                NodeList boardsList = inf.getChildNodes();
                for (int j = 0; j < boardsList.getLength(); j++) {

                    Node panel = boardsList.item(j);
                    if (panel.getNodeType() == Node.ELEMENT_NODE) {

                        Element p = (Element) panel;

                        // Get woodpiece id
                        paramList = new ArrayList<String>();
                        paramList.add(p.getAttribute("id"));
                        woodId = BasicObject.buildBasicObject("Id", paramList);

                        // Get woodpiece number
                        paramList = new ArrayList<String>();
                        paramList.add(p.getAttribute("nombre"));
                        nbrPiecesFromType = BasicObject.buildBasicObject("Number", paramList);

                        int nbr = 0;
                        try{
                            nbr = Integer.parseInt(paramList.get(0));
                        } catch(Exception e){
                            // This exception is already handeled at Number constructor.
                        }

                        // Get woodpiece date
                        paramList = new ArrayList<String>();
                        paramList.add(p.getAttribute("date"));
                        criticalDate = BasicObject.buildBasicObject("Deadline", paramList);
                        
                        // Get woodpiece price
                        paramList = new ArrayList<String>();
                        paramList.add(p.getAttribute("prix"));
                        price = BasicObject.buildBasicObject("Price", paramList);

                        // Get woodpiece Rectangle
                        /*
                            To adapt with Polygone Later.
                        */
                        
                        paramList = new ArrayList<String>();

                            // Dimensions
                        NodeList dimList = panel.getChildNodes();
                        int element_num = 0;
                        for (int k = 0; k < dimList.getLength(); k++) {
                            Node dim = dimList.item(k);
                            if (dim.getNodeType() == Node.ELEMENT_NODE) {

                                Element d = (Element) dim;
                                System.out.println("le tag name est " + d.getTagName());
                                //System.out.println(d.getTagName().equals("dim"));
                                if (d.getTagName().equals("dim") && element_num != 1){
                                    // Setting top left point
                                    paramList.add("0.00");
                                    paramList.add("0.00");
                                    paramList.add(d.getAttribute("L"));
                                    paramList.add(d.getAttribute("l"));
                                    element_num++;                                   
                                }
                                else if (d.getTagName().equals("point")){
                                    paramList.add(d.getAttribute("x"));
                                    paramList.add(d.getAttribute("y"));
                                }
                                else{
                                    throw new RuntimeException("Invalid category : expected dim or point");
                                }
                                //System.out.println("le point k est " + "point" + point_id);
                                //System.out.println(d.getTagName().equals("point" + point_id));


                            }
                        }
                        System.out.println(paramList);
                        if (dimList.getLength() == 1)
                            polygon = BasicObject.buildBasicObject("Rectangle", paramList);
                        else 
                            polygon = BasicObject.buildBasicObject("Polygon", paramList);

                        // Declaring idInsideGroup
                        /*
                            just for basicObjectList allocation.
                        */
                        paramList = new ArrayList<String>();
                        paramList.add("0");
                        idInsideGroup = BasicObject.buildBasicObject("Id", paramList);


                        // Validate objects
                        /*
                            This order is importante for WoodPiece constructor.
                        */
                        ArrayList<BasicObject> basicObjectList = new ArrayList<BasicObject>();
                        basicObjectList.add(actorId);
                        basicObjectList.add(woodId);
                        basicObjectList.add(idInsideGroup);
                        basicObjectList.add(nbrPiecesFromType);
                        basicObjectList.add(polygon);
                        basicObjectList.add(criticalDate);
                        basicObjectList.add(price);

                        boolean valid = true;
                        for (int kk = 0; kk < basicObjectList.size(); kk++) {
                            valid = valid & basicObjectList.get(kk).isValid();
                        }
                        
                        
                        if (valid) {
                            if (tagName == "client") {
                                for (int woodIndex = 0; woodIndex < nbr; woodIndex++) {

                                    paramList = new ArrayList<String>();
                                    paramList.add(String.valueOf(woodIndex));

                                    basicObjectList.set(2, BasicObject.buildBasicObject("Id", paramList));

                                    wood.add(Readable.getReadable("Board", basicObjectList));
                                }
                            }
                            else if (tagName == "fournisseur") {
                                for (int woodIndex = 0; woodIndex < nbr; woodIndex++) {

                                    paramList = new ArrayList<String>();
                                    paramList.add(String.valueOf(woodIndex));

                                    basicObjectList.set(2, BasicObject.buildBasicObject("Id", paramList));

                                    wood.add(Readable.getReadable("Panel", basicObjectList));
                                }
                            }else{
                                throw new RuntimeException("Uknown tagName.");
                            }
                        }
                    }
                }

            }
            return wood;
        }catch(Exception e){
            System.out.println(e);
        }

        /* To exit */
        throw new RuntimeException("Exit");
    }
}
