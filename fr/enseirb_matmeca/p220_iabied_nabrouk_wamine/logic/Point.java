package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Point implements IsValid{

    private double x;
    private double y;

    protected Point(double x, double y){ 
        this.setX(x);
        this.setY(y);
    }

    protected Point(){
        this(.0, .0);
    }
    protected Point(ArrayList<String> point){
        this.x = Double.parseDouble(point.get(0));
        this.y = Double.parseDouble(point.get(1));
    }

    //isValid
    public boolean isValid(){
        return true;
    }

    //getters & setters

    protected double getX(){
        return this.x;
    }
    protected void setX(double x){
        this.x = x;
    }

    protected double getY(){
        return this.y;
    }
    protected void setY(double y){
        this.y = y;
    }

    protected Point deepCopy(){
        return new Point(this.x, this.y);
    }

}
