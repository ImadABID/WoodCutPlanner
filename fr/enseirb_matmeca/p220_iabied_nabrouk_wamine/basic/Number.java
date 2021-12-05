package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Number implements IsValid{
    private int value_num;
    private String value_str;

    public Number(int value){
        this.value_num = value;
    }

    public Number(){
        this(-1);
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

    public int getNumber(){
        return this.value_num;
    }
    public void setNumber(String value){
        this.value_str = value;
    }
    public void setNumber(int value){
        this.value_num = value;
    }

}
