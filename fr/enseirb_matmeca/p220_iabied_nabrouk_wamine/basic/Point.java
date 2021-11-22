package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Point implements IsValid{

    private double x;
    private double y;

    public Point(double x, double y){ 
        this.setX(x);
        this.setY(y);
    }

    public Point(){
        this(.0, .0);
    }

    //isValid
    public boolean isValid(){
        return true;
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

}
