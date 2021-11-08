package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;


import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public class Panel extends WoodPiece{

    public Panel(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
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

}
