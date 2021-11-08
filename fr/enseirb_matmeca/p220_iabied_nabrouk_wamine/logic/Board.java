package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public class Board extends WoodPiece{
    
    private Client client;

    public Board(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
        double price,
        Client client
    ){
        super(
            actorId,
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );

        this.client = client;
    }

    public Client getClient(){
        return this.client;
    }

    public static List<Board> readFromXML(String path, String tagName){

        return new ArrayList<Board>();
    }
    
}