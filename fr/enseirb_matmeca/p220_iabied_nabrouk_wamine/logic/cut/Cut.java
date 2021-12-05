package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;


import java.util.Date;

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
                "The board (clientId=" + String.valueOf(this.board.getActorId().getId())
                + ", typeId=" + String.valueOf(this.board.getTypeId().getId())
                + ", insideGroupId=" + String.valueOf(this.board.getIdInsideGroup().getId())
                + ") <= (supplierId=" + String.valueOf(this.panel.getActorId().getId())
                + ", typeId=" + String.valueOf(this.panel.getTypeId().getId())
                + ", insideGroupId=" + String.valueOf(this.panel.getIdInsideGroup().getId())
                + ") from the position(" + String.valueOf(this.position.getX())
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

    public static boolean is_delivery_possible(Panel panel, Board board) throws ParseException {
        String d_client = board.getCritical_date().date;
        String d_supplier = panel.getCritical_date().date;
        Date date_client = new SimpleDateFormat("dd.MM.yy").parse(d_client);
        Date date_supplier = new SimpleDateFormat("dd.MM.yy").parse(d_supplier);

        return date_supplier.before(date_client);

    }

}
