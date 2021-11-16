package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Rectangle extends Polygon {

    private Point leftTopPt;
    private double lenght;
    private double width;
    
    public Rectangle(Point leftTopPt, double lenght, double width){

        super();

        this.pts.add(leftTopPt);
        this.pts.add(new Point(leftTopPt.getX()+lenght, leftTopPt.getY()));
        this.pts.add(new Point(leftTopPt.getX()+lenght, leftTopPt.getY()+width));
        this.pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

        this.lenght = lenght;
        this.width = width;

    }

    //isValid
    public boolean isValid(){
        return (lenght>0 && width>0 && lenght>width);
    }

    // getters

    public Point getLeftTopPt(){
        return this.leftTopPt;
    }

    public double getLenght(){
        return this.lenght;
    }

    public double getWidth(){
        return this.width;
    }


    public static boolean overlap(Rectangle r1, Rectangle r2){

        // To implement later.

        return false;
    }
}
