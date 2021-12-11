package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

public interface Readable {
    
    public static Readable getReadable(String type, ArrayList<BasicObject> paramList) throws IllegalArgumentException{

        switch(type){

            case "Panel":
                return new Panel(paramList);

            case "Board":
                return new Board(paramList);
            
            default:
                throw new IllegalArgumentException("Uknown type.");
        }
    }
}
