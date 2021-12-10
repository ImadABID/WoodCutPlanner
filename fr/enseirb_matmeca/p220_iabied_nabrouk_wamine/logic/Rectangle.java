package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Rectangle extends Polygon {

    private Point leftTopPt;
    private  double length;
    private  double width;
    private  String length_str;
    private  String width_str;

    private boolean orientation;
    /*
            if orientation = false : Length follows x & Width follows y. "horizontal"
            if orientation = true : Length follows y & Width follows x. "vertical"
    */
    
    protected Rectangle(Point leftTopPt, double length, double width){

        super();

        this.pts.add(leftTopPt);
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()));
        this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()+width));
        this.pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

        this.leftTopPt = leftTopPt;

        this.length = length;
        this.width = width;

        this.orientation = false;

    }
    protected Rectangle(ArrayList<String> rectangle){
        this.leftTopPt.setX(Double.parseDouble(rectangle.get(0)));
        this.leftTopPt.setX(Double.parseDouble(rectangle.get(1)));
        this.length_str = rectangle.get(2);
        this.width_str = rectangle.get(3);
        this.length = Double.parseDouble(rectangle.get(2));
        this.width = Double.parseDouble(rectangle.get(3));
    }

    /*
        It keeps orientation.
    */
    protected Rectangle(Point leftTopPt, double dimx, double dimy, boolean autoDetectLengthWidth){

        this(leftTopPt, dimx, dimy);

        if(autoDetectLengthWidth && dimy > dimx){
            this.length = dimy;
            this.width = dimx;
            this.orientation = true;
        }
    }

    //isValid
    public boolean isValid(){
        try {
            length = Double.parseDouble(length_str);
            width = Double.parseDouble(width_str);
        } catch(NumberFormatException e){
            System.out.println(e);
            return false;
        }
        return (length>0 && width>0 && length>=width);
    }

    // setters
    protected void setLength(String length){
        this.length_str = length;
    }

    protected void setWidth(String width){
        this.width_str = width;
    }
    // getters

    protected Point getLeftTopPt(){
        return this.leftTopPt;
    }
    protected void setLeftTopPt(Point pt){
        this.leftTopPt = pt;
    }

    protected double getLength(){
        return this.length;
    }

    protected double getWidth(){
        return this.width;
    }

    protected double getDimX(){
        if(this.orientation){
            return this.width;
        }
        return this.length;
    }

    protected double getDimY(){
        if(this.orientation){
            return this.length;
        }
        return this.width;
    }

    protected boolean isVertical(){
        return this.orientation;
    }
    protected void setOrientation(boolean orientation){
        this.orientation = orientation;
    }
    protected void setOrientation(String orientation){
        this.orientation = (orientation == "vertical");
    }

    protected Rectangle deepCopy(){
        return new Rectangle(
            this.leftTopPt.deepCopy(),
            this.length,
            this.width
        );
    }

    public String toString(){
        return 
        
            "Rectangle :(Length=" + String.valueOf(this.getLength())
            +",Width=" + String.valueOf(this.getWidth())
            +") (dimX=" + String.valueOf(this.getDimX())
            +", dimY=" + String.valueOf(this.getDimY())
            +")."
        ;
    }

    protected boolean contains(Rectangle r){

        if(this.isVertical()){
            if(r.isVertical()){
                return 
                    this.getLength() >=  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  r.getLength() &&
                    this.getWidth() >=  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  r.getWidth()
                ;
            }else{
                return 
                    this.getLength() >=  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  r.getWidth() &&
                    this.getWidth() >=  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  r.getLength()
                ;
            }
        }else{

            if(r.isVertical()){
                return 
                    this.getLength() >=  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  r.getWidth() &&
                    this.getWidth() >=  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  r.getLength()
                ;
            }else{
                return 
                    this.getLength() >=  r.getLeftTopPt().getX() - this.getLeftTopPt().getX() +  r.getLength() &&
                    this.getWidth() >=  r.getLeftTopPt().getY() - this.getLeftTopPt().getY() +  r.getWidth()
                ;
            }

        }
    }

    protected static boolean overlap(Rectangle r1, Rectangle r2){

        // To implement later.

        return false;
    }

    protected static int compareLexicalOrderLengthWith(Rectangle r1, Rectangle r2){
        
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

    protected static int compareLexicalOrderWithLength(Rectangle r1, Rectangle r2){
        
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
