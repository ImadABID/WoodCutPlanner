package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Rectangle extends Polygon {

    private Point leftTopPt;
    private double length;
    private double width;

    private boolean orientation;
    /*
            if orientation = false : Length follows x & Width follows y. "horizontal"
            if orientation = true : Length follows y & Width follows x. "vertical"
    */
    
    public Rectangle(Point leftTopPt, double length, double width){

        super();

        this.pts.add(leftTopPt);
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()));
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()+width));
        this.pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

        this.length = length;
        this.width = width;

        this.orientation = false;

    }

    //isValid
    public boolean isValid(){
        return (length>0 && width>0 && length>width);
    }

    // getters

    public Point getLeftTopPt(){
        return this.leftTopPt;
    }
    public void setLeftTopPt(Point pt){
        this.leftTopPt = pt;
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }

    public boolean isVertical(){
        return this.orientation;
    }
    public void setOrientation(String orientation){
        this.orientation = (orientation == "vertical");
    }

    public boolean contains(Rectangle r){

        if(this.isVertical()){
            if(r.isVertical()){
                return 
                    this.getLength() >  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  this.getLength() &&
                    this.getWidth() >  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  this.getWidth()
                ;
            }else{
                return 
                    this.getLength() >  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  this.getWidth() &&
                    this.getWidth() >  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  this.getLength()
                ;
            }
        }else{

            if(r.isVertical()){
                return 
                    this.getLength() >  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  this.getWidth() &&
                    this.getWidth() >  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  this.getLength()
                ;
            }else{
                return 
                    this.getLength() >  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  this.getLength() &&
                    this.getWidth() >  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  this.getWidth()
                ;
            }

        }
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
