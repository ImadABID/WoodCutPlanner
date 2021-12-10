package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;

class Board extends WoodPiece {

    private boolean pulledOut;

    protected Board(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Deadline critical_date,
        Price price
    ){
        super(
            actorId,
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );

        this.pulledOut = false;
    }

    protected boolean isPulledOut(){
        return this.pulledOut;
    }
    
    protected void setAsPulledOut(){
        this.pulledOut = true;
    }

    public String toString(){
        return this.toString("client");
    }

    protected static void printList(ArrayList<Board> boards){
        for(int i = 0 ; i < boards.size(); i++){
            System.out.println(boards.get(i));
        }
    }


    protected static ArrayList<Board> read(String path){

        ArrayList<Board> boards = new ArrayList<Board>();

        try {

            ArrayList<? extends WoodPiece> woods = Communicate.readFromXML(path, "client");
            for(int i = 0; i<woods.size(); i++){
                boards.add((Board) woods.get(i));
            }

        } catch (Exception e) {
            System.out.println("read error");
        }

        return boards;

    }

}