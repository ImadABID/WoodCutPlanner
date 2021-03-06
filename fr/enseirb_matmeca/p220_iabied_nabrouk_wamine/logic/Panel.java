package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

class Panel extends WoodPiece{

    public Panel(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Deadline critical_date,
        Price price
    ){
        super(
            actorId,
            typeId, idInsideGroup, nbrPiecesFromType,
            polygon,
            critical_date,
            price
        );
    }

    public Panel(ArrayList<BasicObject> paramList){
        super(paramList);
    }

    public Panel deepCopy(){
        return new Panel(
            new Id(this.actorId.getId()),
            new Id(this.typeId.getId()), new Id(this.idInsideGroup.getId()), new Number(this.nbrPiecesFromType.getNumber()),
            this.polygon.deepCopy(),
            new Deadline(this.critical_date.getDeadline()),
            new Price(this.price.getPrice())
        );
    }

    public String toString(){
        return this.toString("supplier");
    }

    public static void printList(ArrayList<Panel> panels){
        for(int i = 0 ; i < panels.size(); i++){
            Panel panel = panels.get(i);
            System.out.println(panel);
        }
    }

    
    public static ArrayList<Panel> panelsFromReadabls(ArrayList<Readable> readabls){

        ArrayList<Panel> panels = new ArrayList<Panel>();

        for(int i = 0; i < readabls.size(); i++){
            panels.add((Panel) readabls.get(i));
        }
        
        return panels;
    }

}
