package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.Collections;

class Polygon implements BasicObject{
   
    protected ArrayList<Point> pts;
    private Point leftTopPt;


    /*
    public Polygon(ArrayList<Point> pts){
        this.pts = pts;
    }
    */

    public Polygon(ArrayList<String> pts_str){
        int pts_num = pts_str.size();
        if(pts_num%2 != 0){
            throw new RuntimeException("paramList's size is not conform.");
        }
        try{
            this.pts = new ArrayList<Point> ();
            for(int i = 0; i <= pts_num; i = i + 2){
                Point point = new Point(Double.parseDouble(pts_str.get(i)), 
                    Double.parseDouble(pts_str.get(i + 1))
                );   
                System.out.println(pts_str.get(i));
                System.out.println(pts_str.get(i+1));
                this.pts.add(point); 
            }            
        }catch(Exception e){
            System.out.println(e);
        }
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

    public Point computeTopLeftPt(){

        ArrayList<Double> x_table = new ArrayList<Double>();
        ArrayList<Double> y_table = new ArrayList<Double>();

        Point pt;

        for(int i = 0; i < this.pts.size(); i++){
            pt = this.pts.get(i);

            x_table.add(pt.getX());
            y_table.add(pt.getY());
            
        }

        double x_min = Collections.min(x_table);
        double y_min = Collections.min(y_table);

        return new Point(x_min, y_min);
    }

    public Point getLeftTopPt(){
        return this.leftTopPt;
    }
    public void setLeftTopPt(Point topLeftPoint){

        Point diff = Point.difference(topLeftPoint, this.getLeftTopPt());

        for (int i = 0; i < this.pts.size(); i++){
            this.pts.get(i).add(diff);
        }

    }

    public Polygon deepCopy() throws RuntimeException{
        throw new RuntimeException("Not implemented yet.");
    }

    public static boolean overlap(Polygon p1, Polygon p2){

        throw new RuntimeException("Not implemented yet.");

    }

}
