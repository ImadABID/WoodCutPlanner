package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public class Panel extends WoodPiece{

    public Panel(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        String critical_date,
        double price
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
