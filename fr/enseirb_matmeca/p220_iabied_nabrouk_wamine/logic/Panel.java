package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;

class Panel extends WoodPiece{

    protected Panel(
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

    protected Panel deepCopy(){
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

    protected static void printList(ArrayList<Panel> panels){
        for(int i = 0 ; i < panels.size(); i++){
            Panel panel = panels.get(i);
            System.out.println(panel);
        }
    }

    protected static ArrayList<Panel> read(String path){

        ArrayList<Panel> panels = new ArrayList<Panel>();

        try {

            ArrayList<? extends WoodPiece> woods = Communicate.readFromXML(path, "fournisseur");
            for(int i = 0; i<woods.size(); i++){
                panels.add((Panel) woods.get(i));
            }

        } catch (Exception e) {
            System.out.println("read error");
        }

        return panels;

    }

}
