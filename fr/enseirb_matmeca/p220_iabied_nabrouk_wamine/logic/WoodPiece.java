package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry.Polygon;

public abstract class WoodPiece {

    protected int actorId;

    protected int typeId;
    protected int idInsideGroup;
    protected int nbrPiecesFromType;

    protected Polygon polygon;

    protected String critical_date;

    protected double price;

    public WoodPiece(
        int actorId,
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        Polygon polygon,
        String critical_date,
        double price
    ) throws IllegalArgumentException{

        if(actorId < 0 || typeId < 0 || idInsideGroup >= nbrPiecesFromType || nbrPiecesFromType <= 0){
            throw new IllegalArgumentException();
        }

        this.actorId = actorId;

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

    public String getCritical_date(){
        return this.critical_date;
    }

    public double getPrice(){
        return this.price;
    }


}