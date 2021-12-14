package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Point implements BasicObject{

    private double x;
    private double y;
    private boolean isValid;

    protected Point(double x, double y){ 
        this.setX(x);
        this.setY(y);
        this.isValid = true;
    }

    protected Point(ArrayList<String> paramList){

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
