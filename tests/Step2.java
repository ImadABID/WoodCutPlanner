package tests;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;

public class Step2{
    public static void main(String[] args) {
        
        ArrayList<Panel> panels = Panel.read("fournisseurs.xml");
        Panel.printList(panels);

        ArrayList<Board> boards = Board.read("clients.xml");
        Board.printList(boards);


    }
}