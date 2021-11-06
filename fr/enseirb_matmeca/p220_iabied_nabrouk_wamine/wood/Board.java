package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Client;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public class Board extends WoodPiece{
    
    private Client client;

    public Board(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
        double price,
        Client client
    ){
        super(
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
    
}
