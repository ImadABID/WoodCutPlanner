package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class Step2{
    public static void main(String[] args) throws ParserConfigurationException, ParseException, IOException, SAXException {

        CutAlgos algos=new CutStep2Algo();
        
        ArrayList<Panel> panels = Panel.read("fournisseurs.xml");
        Panel.printList(panels);

        ArrayList<Board> boards = Board.read("clients.xml");
       // Board.printList(boards);

        ArrayList<Cut> cuts = (ArrayList) algos.optimiseCuts(boards,panels);
        //Cut.printList(cuts);
        ArrayList<Panel> panels_c=new ArrayList<Panel>();
        for (int i=0;i<cuts.size();i++){
            panels_c.add(cuts.get(i).getPanel());

        }
        Panel.printList(panels_c);




    }
}