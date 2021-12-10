package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Number implements IsValid{
    private int value_num;
    private String value_str;

    protected Number(int value){
        this.value_num = value;
    }

    protected Number(){
        this(-1);
    }
    protected Number(ArrayList<String> number){
        this.value_str = number.get(0);
        this.value_num = Integer.parseInt(number.get(0));
    }

    @Override
    public boolean isValid() {
        try {
            value_num = Integer.parseInt(value_str);
        } catch(NumberFormatException e){
            System.out.println(e);
            return false;
        }
        if(value_num < 0)
        {
            throw new IllegalArgumentException("Invalid Number : number must be positive");
            //return false;
        }
        return true;
    }


    //getters & setters

    protected int getNumber(){
        return this.value_num;
    }
    protected void setNumber(String value){
        this.value_str = value;
    }
    protected void setNumber(int value){
        this.value_num = value;
    }

}
