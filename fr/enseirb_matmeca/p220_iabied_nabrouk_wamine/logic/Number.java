package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Number implements BasicObject{

    private int value;
    private boolean isValid;

    public Number(int value){
        try {

            this.value = value;

            if(this.value < 0){
                throw new RuntimeException("Number cannot be negatif.");
            }

            this.isValid = true;

        } catch (Exception e) {
            this.isValid = false;
            System.out.println(e);
        }
    }

    public Number(ArrayList<String> paramList){

        if(paramList.size() != 1){
            throw new RuntimeException("paramList is not conform.");
        }

        try{
            this.value = Integer.parseInt(paramList.get(0));
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
    public boolean isValid() {
        return this.isValid;
    }


    //getters & setters

    public int getNumber(){
        return this.value;
    }

}
