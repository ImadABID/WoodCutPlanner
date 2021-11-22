package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.CutStep3Algo1;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Step3Algo1{
    public static void main(String[] args) throws ParserConfigurationException, IOException, ParseException, TransformerException, SAXException {
        
        ArrayList<Panel> panels = Panel.read("fournisseurs.xml");
        ArrayList<Board> boards = Board.read("clients.xml");
        
        ArrayList<Cut> cuts = new CutStep3Algo1().optimiseCuts(boards, panels);

        Cut.printList(cuts);
        Communicate.generateCutsXML(cuts);

    }
}