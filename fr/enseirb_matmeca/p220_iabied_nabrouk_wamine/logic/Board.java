package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Date;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Id;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Price;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;

public class Board extends WoodPiece {

    public Board(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
        Price price
    ){
        super(
            actorId,
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );
    }

    public String toString(){
        return this.toString("client");
    }

    public static void printList(ArrayList<Board> boards){
        for(int i = 0 ; i < boards.size(); i++){
            System.out.println(boards.get(i));
        }
    }


    public static ArrayList<Board> read(String path){

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