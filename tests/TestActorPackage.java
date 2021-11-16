package tests;


import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate.readFromXML;


public class TestActorPackage {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException {


        // Testing Client
        String tagName = "client";
        List<WoodPiece> wood = readFromXML("clients.xml", tagName);
        for(int i = 0 ; i < wood.size(); i++){
            WoodPiece w = wood.get(i);
            System.out.println(
                    tagName+"Id=" + w.getActorId().value
                    + "\ttypeId=" + w.getTypeId().value
                    + "\tinsideGroupId=" + w.getIdInsideGroup().value
                    + "\tnumber=" + w.getNbrPiecesFromType().value
                    + "\tdate=" + w.getCritical_date().date
                    + "\tprice=" + w.getPrice().value_2
            );
        }

    }

}
