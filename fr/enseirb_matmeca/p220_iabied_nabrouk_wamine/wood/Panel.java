package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Supplier;

public class Panel extends RectuangularWoodPiece{
    
    private Supplier supplier;

    public Panel(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        double length, double width,
        Date critical_date,
        double price,
        Supplier supplier
    ){
        super(
            typeId, idInsideGroup, nbrPiecesFromType,
            length, width,
            critical_date,
            price
        );

        this.supplier = supplier;
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

}
