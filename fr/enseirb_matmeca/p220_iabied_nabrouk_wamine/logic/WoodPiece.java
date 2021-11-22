package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Date;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Id;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Price;

public abstract class WoodPiece {

    protected Id actorId;

    protected Id typeId;
    protected Id idInsideGroup;
    protected Number nbrPiecesFromType;

    protected Polygon polygon;

    protected Date critical_date;

    protected Price price;

    public WoodPiece(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
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

    public Date getCritical_date(){
        return this.critical_date;
    }

    public Price getPrice(){
        return this.price;
    }

    // toString

    public String toString(String actorType){
        return 
            actorType+"Id=" + this.getActorId().value
            + "\ttypeId=" + this.getTypeId().value
            + "\tinsideGroupId=" + this.getIdInsideGroup().value
            + "\tnumber=" + this.getNbrPiecesFromType().value
            + "\tdate=" + this.getCritical_date().date
            + "\tprice=" + this.getPrice().value_2
        ;
    }

    //seters

    public void setNbrPiecesFromType(Number nbrPiecesFromType){
        this.nbrPiecesFromType=nbrPiecesFromType;
    }
}