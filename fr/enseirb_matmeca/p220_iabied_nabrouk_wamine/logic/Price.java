package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Price implements IsValid {

    private String value_str;
    private Float value_num;

    protected Price(Float value){
        this.value_num = value;
    }

    protected Price(String value){
        this.value_str = value;
    }

    protected Price(){
        this("-1.0");
    }
    protected Price(ArrayList<String> price){
        this.value_str = price.get(0);
        this.value_num = Float.parseFloat(price.get(0));
    }

    @Override
    public boolean isValid()
    {
        try {
            value_num = Float.parseFloat(value_str);
        } catch(NumberFormatException e){
            System.out.println(e);
            return false;
        }
        final  String PriceFormat = "^\\d+(\\.\\d\\d)";
        if (!(value_str.matches(PriceFormat))){
            throw new IllegalArgumentException("Invalid price format  ");
        }
        else if (value_num <0) {
            throw new IllegalArgumentException("Invalid Price : price must be positive");
            //return false;
        }
        return true;
    }

    
     //getters & setters

    protected Float getPrice(){
        return this.value_num;
    }
    protected void setPrice(String price){
        this.value_str = price;
    }

}