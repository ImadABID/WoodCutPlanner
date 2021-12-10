package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;
import java.util.ArrayList;

class Id implements IsValid{   
    private int value_num;
    private String value_str;

    protected Id(int value){
        this.value_num = value;
    }

    protected Id(){
        this(-1);
    }
    protected Id(ArrayList<String> id){
        this.value_str = id.get(0);
        this.value_num = Integer.parseInt(id.get(0));
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
            throw new IllegalArgumentException("Invalid actorid : actor id must be positive");
            //return false;
        }
        return true;
    }


    //getters

    protected int getId(){
        return this.value_num;
    }
    protected void setId(String id){
        this.value_str = id;
    }

}
