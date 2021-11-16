package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;

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

}
