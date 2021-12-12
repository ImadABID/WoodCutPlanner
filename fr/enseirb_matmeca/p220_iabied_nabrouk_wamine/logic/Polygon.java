package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

class Polygon implements BasicObject{
   
    protected ArrayList<Point> pts;

    /*
    public Polygon(ArrayList<Point> pts){
        this.pts = pts;
    }
    */

    public Polygon(ArrayList<String> pts_str){
        throw new RuntimeException("Not implemented yet.");
    }

    // For Recatangle constructors
    public Polygon(){}


    //isValid
    public boolean isValid(){
        throw new RuntimeException("Not implemented yet.");
    }

    // getters
    public ArrayList<Point> getPts(){
        return this.pts;
    }

    public Polygon deepCopy() throws RuntimeException{
        throw new RuntimeException("Not implemented yet.");
    }

    public static boolean overlap(Polygon p1, Polygon p2){

        throw new RuntimeException("Not implemented yet.");

    }

}
