package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Rectangle;

public class Board extends WoodPiece{
    
    private Client client;

    public Board(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        String critical_date,
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

    public Board(int actor_id, int panel_id, int panel_id1, int number, Rectangle rect, String date, float price) {
        super(actor_id,panel_id,panel_id1, number, rect, date, price);
    }
}