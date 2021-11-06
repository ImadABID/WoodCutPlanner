package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
   
    protected List<Point> pts;

    public Polygon(List<Point> pts){
        this.pts = pts;
    }

    public Polygon(){
        this(new ArrayList<Point>());
    }

    // getters
    public List<Point> getPts(){
        return this.pts;
    }

    public static boolean overlap(Polygon p1, Polygon p2){

        // To implement later.

        return false;
    }

}
