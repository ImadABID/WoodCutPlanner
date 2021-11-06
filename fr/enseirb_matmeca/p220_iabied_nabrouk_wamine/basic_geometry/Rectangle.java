package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic_geometry;

public class Rectangle extends Polygon {

    private Point leftTopPt;
    private double lenght;
    private double width;
    
    public Rectangle(Point leftTopPt, double lenght, double width) throws IllegalArgumentException{

        super();

        if(lenght < .0 || width < .0){
            throw new IllegalArgumentException();
        }

        pts.add(leftTopPt);
        pts.add(new Point(leftTopPt.getX()+lenght, leftTopPt.getY()));
        pts.add(new Point(leftTopPt.getX()+lenght, leftTopPt.getY()+width));
        pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

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
