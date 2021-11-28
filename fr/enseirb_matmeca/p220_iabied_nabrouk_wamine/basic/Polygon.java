package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements IsValid{
   
    protected List<Point> pts;

    public Polygon(List<Point> pts){
        this.pts = pts;
    }

    public Polygon(){
        this(new ArrayList<Point>());
    }

    //isValid
    public boolean isValid(){
        return true;
    }

    // getters
    public List<Point> getPts(){
        return this.pts;
    }

    public Polygon deepCopy() throws RuntimeException{
        throw new RuntimeException("Polygon.deepCopy not implemented yet.");
    }

    public static boolean overlap(Polygon p1, Polygon p2){

        // To implement later.

        return false;
    }

}
