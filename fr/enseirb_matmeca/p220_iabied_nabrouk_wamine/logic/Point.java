package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Point implements BasicObject{

    private double x;
    private double y;
    private boolean isValid;

    public Point(double x, double y){ 
        this.setX(x);
        this.setY(y);
        this.isValid = true;
    }

    public Point(ArrayList<String> paramList){

        if(paramList.size() != 2){
            throw new RuntimeException("paramList is not conform.");
        }

        try{
            this.x = Double.parseDouble(paramList.get(0));
            this.y = Double.parseDouble(paramList.get(1));
            this.isValid = true;
        }catch (Exception e){
            this.isValid = false;
            System.out.println(e);
        }
    }

    //isValid
    public boolean isValid(){
        return this.isValid;
    }

    //getters & setters

    public double getX(){
        return this.x;
    }
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return this.y;
    }
    public void setY(double y){
        this.y = y;
    }

    public Point deepCopy(){
        return new Point(this.x, this.y);
    }

    public void add(Point toAdd){
        this.x += toAdd.x;
        this.y += toAdd.y;
    }

    public static Point difference(Point Pt1, Point Pt2){
        return new Point(Pt1.getX() - Pt2.getX(), Pt1.getY() - Pt2.getY());
    }

}
