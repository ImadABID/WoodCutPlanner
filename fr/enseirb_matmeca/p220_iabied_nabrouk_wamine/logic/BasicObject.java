package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

public interface BasicObject{

    public static BasicObject buildBasicObject(String type, ArrayList<String> paramList) throws IllegalArgumentException{

        switch(type){

            case "Point":
                return new Point(paramList);
                
            case "Polygon":
                return new Polygon(paramList);

            case "Rectangle":
                return new Rectangle(paramList);

            case "Id":
                return new Id(paramList);

            case "Number":
                return new Number(paramList);
            
            case "Price":
                return new Price(paramList);

            case "Deadline":
                return new Deadline(paramList);

            default:
                throw new IllegalArgumentException("Uknown type.");

        }
    }

    public boolean isValid();

}