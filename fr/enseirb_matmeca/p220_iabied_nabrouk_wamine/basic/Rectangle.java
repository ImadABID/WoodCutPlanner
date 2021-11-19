package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Rectangle extends Polygon {

    private Point leftTopPt;
    private double length;
    private double width;
    
    public Rectangle(Point leftTopPt, double length, double width){

        super();

        this.pts.add(leftTopPt);
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()));
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()+width));
        this.pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

        this.length = length;
        this.width = width;

    }

    //isValid
    public boolean isValid(){
        return (length>0 && width>0 && length>width);
    }

    // getters

    public Point getLeftTopPt(){
        return this.leftTopPt;
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }


    public static boolean overlap(Rectangle r1, Rectangle r2){

        // To implement later.

        return false;
    }

    public static int compareLexicalOrderLengthWith(Rectangle r1, Rectangle r2){
        
        // Decreasing order

        if(r1.length > r2.length){
            return -1;
        }

        if(r1.length < r2.length){
            return 1;
        }

        if(r1.width > r2.width){
            return -1;
        }

        if(r1.width < r2.width){
            return 1;
        }

        return 0;
        
    }

    public static int compareLexicalOrderWithLength(Rectangle r1, Rectangle r2){
        
        // Decreasing order

        if(r1.width > r2.width){
            return -1;
        }

        if(r1.width < r2.width){
            return 1;
        }

        if(r1.length > r2.length){
            return -1;
        }

        if(r1.length < r2.length){
            return 1;
        }

        return 0;
        
    }
}
