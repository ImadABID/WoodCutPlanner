package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;


import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Rectangle;

public class Panel extends WoodPiece{

    public Panel(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        String critical_date,
        double price,
        Supplier supplier
    ){
        super(
            actorId,
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );
    }

    public Panel(int actor_id, int panel_id, int panel_id1, int number, Rectangle rect, String date, float price) {
        super(actor_id,panel_id,panel_id1, number, rect, date, price);
    }
}
