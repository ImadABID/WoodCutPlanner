package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Deadline;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Id;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Price;

public abstract class WoodPiece {

    protected Id actorId;

    protected Id typeId;
    protected Id idInsideGroup;
    protected Number nbrPiecesFromType;

    protected Polygon polygon;

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

        this.critical_date = critical_date;

        this.price = price;

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