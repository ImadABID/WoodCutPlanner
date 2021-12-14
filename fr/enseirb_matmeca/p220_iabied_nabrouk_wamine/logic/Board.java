package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

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

    protected Board(ArrayList<BasicObject> paramList){
        super(paramList);
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


    public static ArrayList<Board> boardsFromReadabls(ArrayList<Readable> readabls){

        ArrayList<Board> boards = new ArrayList<Board>();

        for(int i = 0; i < readabls.size(); i++){
            boards.add((Board) readabls.get(i));
        }
        
        return boards;
    }

}