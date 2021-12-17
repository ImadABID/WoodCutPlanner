package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;

class Cut implements Writable{

    private Panel panel;
    private Board board;
    private Point position; // board's decalage

    public Cut(Panel panel, Board board, Point position){

        this.panel = panel;
        this.board = board;
        this.position = position;

        this.board.getPolygon().setLeftTopPt(position);
        this.board.getBoundingRect().setLeftTopPt(position);

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

    public ArrayList<String> getFields(){
        ArrayList<String> field_string = new ArrayList<String>();

        // Board actor Id
        field_string.add(String.valueOf(this.board.getActorId().getId()));

        // Board Id
        field_string.add(
            String.valueOf(this.board.getTypeId().getId())
            +"."+
            String.valueOf(this.board.getIdInsideGroup().getId())
        );

        // Panel actor Id
        field_string.add(String.valueOf(this.panel.getActorId().getId()));

        // Panel Id
        field_string.add(
            String.valueOf(this.panel.getTypeId().getId())
            +"."+
            String.valueOf(this.panel.getIdInsideGroup().getId())
        );

        // Position
        field_string.add(String.valueOf(this.position.getX()));
        field_string.add(String.valueOf(this.position.getY()));

        // Wood Piece
        ArrayList<Point> pts;
        Point pt;

        // 1 - Board : a list of path pt : [x_py1, y_py1, x_py2, y_py2, ...]

        // ---- point nbr
        field_string.add(String.valueOf(this.board.getPolygon().getPts().size()));

        // ---- adding the pts coordinates
        pts = this.board.getPolygon().getPts();
        for(int i = 0; i < pts.size(); i++){
            pt = this.board.getPolygon().getPts().get(i);
            field_string.add(String.valueOf(pt.getX()));
            field_string.add(String.valueOf(pt.getY()));
        }

        // 2 - Panel : a list of path pt : [x_py1, y_py1, x_py2, y_py2, ...]

        // ---- point nbr
        field_string.add(String.valueOf(this.panel.getPolygon().getPts().size()));

        // ---- adding the pts coordinates
        pts = this.panel.getPolygon().getPts();
        for(int i = 0; i < pts.size(); i++){
            pt = this.panel.getPolygon().getPts().get(i);
            field_string.add(String.valueOf(pt.getX()));
            field_string.add(String.valueOf(pt.getY()));
        }

        return field_string;
    }

    public String toString(){
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

    public static void printList(ArrayList<Cut> cuts){
        for(int i = 0 ; i < cuts.size(); i++){
            System.out.println(cuts.get(i));
        }
    }

    public boolean is_delivery_possible() {

        try{

            String d_client = this.board.getCritical_date().getDeadline();
            String d_supplier = this.panel.getCritical_date().getDeadline();

            Date date_client = new SimpleDateFormat("dd.MM.yy").parse(d_client);
            Date date_supplier = new SimpleDateFormat("dd.MM.yy").parse(d_supplier);

            return date_supplier.before(date_client);

        }catch(Exception e){
            System.out.println(e);
        }

        throw new RuntimeException("Exit");

    }

}
