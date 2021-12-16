package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Rectangle extends Polygon {

    private Point leftTopPt;
    private  double length;
    private  double width;

    private boolean orientation;
    /*
            if orientation = false : Length follows x & Width follows y. "horizontal"
            if orientation = true : Length follows y & Width follows x. "vertical"
    */

    private boolean isValid;
    
    public Rectangle(Point leftTopPt, double length, double width){

        try{

            /*

            Use super instead of this.

            this.pts.add(leftTopPt);
            this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()));
            this.pts.add(new Point(leftTopPt.getX()+length, leftTopPt.getY()+width));
            this.pts.add(new Point(leftTopPt.getX(), leftTopPt.getY()+width));

            this.leftTopPt = leftTopPt;
            */

            this.length = length;
            this.width = width;

            if(this.length <= 0 || this.width <= 0){
                throw new RuntimeException("Dimensions cannot be negatif or null.");
            }

            if(this.length < this.width){
                throw new RuntimeException("length < width");
            }

            this.orientation = false;
            
            this.isValid = true;

        }catch(Exception e){
            this.isValid = false;
            System.out.println(e);
        }

    }

    public Rectangle(ArrayList<String> paramList){

        if(paramList.size() != 4){
            throw new RuntimeException("paramList is not conform.");
        }

        try{

            this.leftTopPt = new Point(
                Double.parseDouble(paramList.get(0)), 
                Double.parseDouble(paramList.get(1))
            );

            this.length = Double.parseDouble(paramList.get(2));
            this.width = Double.parseDouble(paramList.get(3));

            if(this.length <= 0 || this.width <= 0){
                throw new RuntimeException("Dimensions cannot be negatif or null.");
            }

            if(this.length < this.width){
                throw new RuntimeException("length < width");
            }

            this.orientation = false;

            this.isValid = true;
            
        }catch(Exception e){
            this.isValid = false;
            System.out.println(e);
        }
    }

    /*
        * It keeps orientation.

        * boolean autoDetectLengthWidth : is not considerd (always true).
            it is used just to make difference between constructors.

    */
    public Rectangle(Point leftTopPt, double dimx, double dimy, boolean autoDetectLengthWidth){

        this.leftTopPt = leftTopPt;

        if(dimy > dimx){
            this.length = dimy;
            this.width = dimx;
            this.orientation = true;
        }else{
            this.length = dimx;
            this.width = dimy;
            this.orientation = false;
        }

        this.isValid = true;
    }

    //isValid
    public boolean isValid(){
        return this.isValid;
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

    public double getDimX(){
        if(this.orientation){
            return this.width;
        }
        return this.length;
    }

    public double getDimY(){
        if(this.orientation){
            return this.length;
        }
        return this.width;
    }

    public boolean isVertical(){
        return this.orientation;
    }
    public void setOrientation(boolean orientation){
        this.orientation = orientation;
    }
    public void setOrientation(String orientation){
        this.orientation = (orientation == "vertical");
    }

    public Rectangle deepCopy(){
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

    public boolean contains(Rectangle r){

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
