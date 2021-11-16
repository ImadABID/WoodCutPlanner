package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Date;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Id;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Polygon;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Price;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Communicate;

public class Panel extends WoodPiece{

    public Panel(
        Id actorId,
        Id typeId, Id idInsideGroup, Number nbrPiecesFromType,
        Polygon polygon,
        Date critical_date,
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

    public String toString(){
        return this.toString("supplier");
    }

    public static void printList(ArrayList<Panel> panels){
        for(int i = 0 ; i < panels.size(); i++){
            Panel panel = panels.get(i);
            System.out.println(panel);
        }
    }

    public static ArrayList<Panel> read(String path){

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
