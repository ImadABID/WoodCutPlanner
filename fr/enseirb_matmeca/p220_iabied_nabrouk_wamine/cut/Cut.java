package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.cut;

import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood.Panel;

public class Cut {

    private Panel panel;
    private Board board;
    private Point position; // board's decalage

    public Cut(Panel panel, Board board, Point position){
        this.panel = panel;
        this.board = board;
        this.position = position;
    }

    public Panel getPanel(){
        return this.panel;
    }

    public Board getBoard(){
        return this.board;
    }

    public Point getPosition(){
        return this.position;
    }

    public static void generateSVG(List<Cut> cuts, String path){
        // To implement later.
    }

    public static void generateXML(List<Cut> cuts, String path){
        // To implement later.
    }

}
