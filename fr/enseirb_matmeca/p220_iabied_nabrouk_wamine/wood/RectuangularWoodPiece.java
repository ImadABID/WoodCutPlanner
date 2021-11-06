package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood;

import java.util.Date;

public abstract class RectuangularWoodPiece {

    protected int typeId;
    protected int idInsideGroup;
    protected int nbrPiecesFromType;

    protected double length;
    protected double width;

    protected Date critical_date;

    protected double price;

    public RectuangularWoodPiece(
        int typeId, int idInsideGroup, int nbrPiecesFromType,
        double length, double width,
        Date critical_date,
        double price
    ) throws IllegalArgumentException{

        if( length <= .0 || width <= .0 || typeId < 0 || idInsideGroup >= nbrPiecesFromType || nbrPiecesFromType <= 0){
            throw new IllegalArgumentException();
        }

        this.typeId = typeId;
        this.idInsideGroup = idInsideGroup;
        this.nbrPiecesFromType = nbrPiecesFromType;

        this.length = length;
        this.width = width;

        this.critical_date = critical_date;

        this.price = price;

    }

    // geters

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }

    public int getTypeId(){
        return this.typeId;
    }

    public int getIdInsideGroup(){
        return this.idInsideGroup;
    }

    public int getNbrPiecesFromType(){
        return this.nbrPiecesFromType;
    }

    public Date getCritical_date(){
        return this.critical_date;
    }

    public double getPrice(){
        return this.price;
    }


}
