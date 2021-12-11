package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;

class Cut implements Writeable{

    private Panel panel;
    private Board board;
    private Point position; // board's decalage

    protected Cut(Panel panel, Board board, Point position){
        this.panel = panel;
        this.board = board;
        this.position = position;
    }

    protected Panel getPanel(){
        return this.panel;
    }

    protected Board getBoard(){
        return this.board;
    }

    protected Point getPosition(){
        return this.position;
    }

    public ArrayList<String> getFields(){
        ArrayList<String> field_string = new ArrayList<String>();

        field_string.add(String.valueOf(this.board.getActorId().getId()));
        field_string.add(String.valueOf(this.board.getTypeId().getId()));
        field_string.add(String.valueOf(this.board.getIdInsideGroup().getId()));

        field_string.add(String.valueOf(this.panel.getActorId().getId()));
        field_string.add(String.valueOf(this.panel.getTypeId().getId()));
        field_string.add(String.valueOf(this.panel.getIdInsideGroup().getId()));

        field_string.add(String.valueOf(this.position.getX()));
        field_string.add(String.valueOf(this.position.getY()));

        return field_string;
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

    protected static void printList(ArrayList<Cut> cuts){
        for(int i = 0 ; i < cuts.size(); i++){
            System.out.println(cuts.get(i));
        }
    }

    protected boolean is_delivery_possible() throws ParseException {
        String d_client = this.board.getCritical_date().getDeadline();
        String d_supplier = this.panel.getCritical_date().getDeadline();
        Date date_client = new SimpleDateFormat("dd.MM.yy").parse(d_client);
        Date date_supplier = new SimpleDateFormat("dd.MM.yy").parse(d_supplier);

        return date_supplier.before(date_client);

    }

}
