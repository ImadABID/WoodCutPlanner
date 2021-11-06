package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Client;

public class Board extends RectuangularWoodPiece{
    
    private Client client;

    public Board(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        double length, double width,
        Date critical_date,
        double price,
        Client client
    ){
        super(
            typeId, idInsideGroup, nbrPiecesFromType,
            length, width,
            critical_date,
            price
        );

        this.client = client;
    }

    public Client getClient(){
        return this.client;
    }
    
}
