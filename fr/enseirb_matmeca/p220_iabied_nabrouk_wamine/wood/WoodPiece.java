package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public abstract class WoodPiece {

    protected int typeId;
    protected int idInsideGroup;
    protected int nbrPiecesFromType;

    protected Polygon polygon;

    protected Date critical_date;

    protected double price;

    public WoodPiece(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
        double price
    ) throws IllegalArgumentException{

        if(typeId < 0 || idInsideGroup >= nbrPiecesFromType || nbrPiecesFromType <= 0){
            throw new IllegalArgumentException();
        }

        this.typeId = typeId;
        this.idInsideGroup = idInsideGroup;
        this.nbrPiecesFromType = nbrPiecesFromType;

        this.polygon = polygon;

        this.critical_date = critical_date;

        this.price = price;

    }

    // geters

    public int getTypeId(){
        return this.typeId;
    }

    public int getIdInsideGroup(){
        return this.idInsideGroup;
    }

    public int getNbrPiecesFromType(){
        return this.nbrPiecesFromType;
    }

    public Polygon getPolygon(){
        return this.polygon;
    }

    public Date getCritical_date(){
        return this.critical_date;
    }

    public double getPrice(){
        return this.price;
    }


}
