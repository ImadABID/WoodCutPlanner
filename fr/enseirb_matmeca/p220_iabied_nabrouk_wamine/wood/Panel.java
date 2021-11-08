package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Supplier;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public class Panel extends WoodPiece{
    
    private Supplier supplier;

    public Panel(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
        double price,
        Supplier supplier
    ){
        super(
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );

        this.supplier = supplier;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public static List<Panel> readFromXML(String path, String tagName){

        return new ArrayList<Panel>();
    }

}
