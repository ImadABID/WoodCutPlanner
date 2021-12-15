package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Price implements BasicObject {

    private Double value;

    private boolean isValid;

    public Price(Double value){
        try {

            this.value = value;

            if(this.value < 0){
                throw new RuntimeException("Price cannot be negatif.");
            }

            this.isValid = true;

        } catch (Exception e) {
            this.isValid = false;
            System.out.println(e);
        }
    }

    public Price(ArrayList<String> paramList){

        if(paramList.size() != 1){
            throw new RuntimeException("paramList is not conform.");
        }

        try{
            this.value = Double.parseDouble(paramList.get(0));
            if(this.value < 0){
                throw new RuntimeException("Number cannot be negatif.");
            }
            this.isValid = true;
        }catch(Exception e){
            this.isValid = false;
            System.out.println(e);
        }
    }

    @Override
    public boolean isValid()
    {
        return this.isValid;
    }

    //getters & setters

    public Double getPrice(){
        return this.value;
    }

}