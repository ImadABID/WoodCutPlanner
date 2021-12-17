package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;


abstract class WoodPiece implements Readable{

    protected Id actorId;
    protected Id typeId;
    protected Id idInsideGroup;
    protected Number nbrPiecesFromType;

    protected Polygon polygon;
    protected Rectangle boundingRect;

    protected Deadline critical_date;

    protected Price price;

    public WoodPiece(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Deadline critical_date,
        Price price
    ){

        this.actorId = actorId;

        this.typeId = typeId;
        this.idInsideGroup = idInsideGroup;
        this.nbrPiecesFromType = nbrPiecesFromType;

        this.polygon = polygon;
        this.boundingRect = new Rectangle(polygon);

        this.critical_date = critical_date;

        this.price = price;

    }

    public WoodPiece(ArrayList<BasicObject> paramList){

        if(paramList.size() != 7){
            throw new RuntimeException("paramList is not conform.");
        }

        if (! (paramList.get(0) instanceof Id)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.actorId = (Id)paramList.get(0);

        if (! (paramList.get(1) instanceof Id)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.typeId = (Id)paramList.get(1);

        if (! (paramList.get(2) instanceof Id)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.idInsideGroup = (Id)paramList.get(2);

        if (! (paramList.get(3) instanceof Number)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.nbrPiecesFromType = (Number) paramList.get(3);

        if (! (paramList.get(4) instanceof Polygon)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.polygon = (Polygon) paramList.get(4);

        if (! (paramList.get(5) instanceof Deadline)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.critical_date = (Deadline) paramList.get(5);

        if (! (paramList.get(6) instanceof Price)){
            throw new RuntimeException("paramList is not conform.");
        }
        this.price = (Price) paramList.get(6);

    }

    // geters

    public Id getActorId(){
        return this.actorId;
    }

    public Id getTypeId(){
        return this.typeId;
    }

    public Id getIdInsideGroup(){
        return this.idInsideGroup;
    }

    public Number getNbrPiecesFromType(){
        return this.nbrPiecesFromType;
    }

    public Polygon getPolygon(){
        return this.polygon;
    }
    public void setPolygone(Polygon p){
        this.polygon = p;
    }

    public Rectangle getBoundingRect(){
        return this.boundingRect;
    }
    public void setPolygone(Rectangle rect){
        this.boundingRect = rect;
    }

    public Deadline getCritical_date(){
        return this.critical_date;
    }

    public Price getPrice(){
        return this.price;
    }

    // toString

    public String toString(String actorType){
        return 
            actorType+"Id = " + this.getActorId().getId()
            + "\t\ttypeId = " + this.getTypeId().getId()
            + "\t\tinsideGroupId = " + this.getIdInsideGroup().getId()
            + "\t\tnumber = " + this.getNbrPiecesFromType().getNumber()
            + "\t\tdate = " + this.getCritical_date().getDeadline()
            + "\t\tprice = " + this.getPrice().getPrice()
            + "\n\t " + this.getPolygon().toString()
        ;
    }

    //seters

    public void setNbrPiecesFromType(Number nbrPiecesFromType){
        this.nbrPiecesFromType=nbrPiecesFromType;
    }
}