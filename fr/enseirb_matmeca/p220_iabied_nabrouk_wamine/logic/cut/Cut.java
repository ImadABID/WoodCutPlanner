package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;

import java.util.ArrayList;

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

    public String toString(){
        if(this.board.getPolygon() instanceof Rectangle){
            return
                "The board (typeId=" + String.valueOf(this.board.getTypeId().value)
                + ", insideGroupId=" + String.valueOf(this.board.getIdInsideGroup().value)
                + ") is going to be pulled out from the pannel (typeId=" + String.valueOf(this.panel.getTypeId().value)
                + ", insideGroupId=" + String.valueOf(this.panel.getIdInsideGroup().value)
                + ")"
                + "from the position(" + String.valueOf(this.position.getX())
                + ", " + String.valueOf(this.position.getY())
                + ")."
            ;
        }

        return "Displaying Cut info for non Rectangle Polygon is not implemented yet.";
    }

    public static void printList(ArrayList<Cut> cuts){
        for(int i = 0 ; i < cuts.size(); i++){
            System.out.println(cuts.get(i));
        }
    }

}
