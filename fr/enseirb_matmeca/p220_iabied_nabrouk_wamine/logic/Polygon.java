package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.List;

class Polygon implements BasicObject{
   
    protected List<Point> pts;

    protected Polygon(List<Point> pts){
        this.pts = pts;
    }

    protected Polygon(){
        this(new ArrayList<Point>());
    }

    //isValid
    public boolean isValid(){
        return true;
    }

    // getters
    protected List<Point> getPts(){
        return this.pts;
    }

    protected Polygon deepCopy() throws RuntimeException{
        throw new RuntimeException("Polygon.deepCopy not implemented yet.");
    }

    protected static boolean overlap(Polygon p1, Polygon p2){

        // To implement later.

        return false;
    }

}
