package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    public Point(){
        this(.0, .0);
    }

    //getters & setters

    public double getX(){
        return this.x;
    }
    public void setX(double x) throws IllegalArgumentException{
        if(x<.0){
            throw new IllegalArgumentException();
        }
        this.x = x;
    }

    public double getY(){
        return this.y;
    }
    public void setY(double y) throws IllegalArgumentException{
        if(y<.0){
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

}
