package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Step2{
    public static void main(String[] args) throws ParserConfigurationException, ParseException, IOException, SAXException, TransformerException {

        CutAlgos algos=new CutStep2Algo();
        
        ArrayList<Panel> panels = Panel.read("fournisseurs.xml");
        //Panel.printList(panels);

        ArrayList<Board> boards = Board.read("clients.xml");

        ArrayList<Cut> cuts = algos.optimiseCuts(boards,panels);
        Cut.printList(cuts);

        Communicate.generateCutsXML(cuts);




    }
}