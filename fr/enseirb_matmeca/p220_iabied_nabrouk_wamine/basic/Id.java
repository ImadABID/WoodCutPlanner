package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Id implements IsValid{   
    private int value_num;
    private String value_str;

    public Id(int value){
        this.value_num = value;
    }

    public Id(){
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
            throw new IllegalArgumentException("Invalid actorid : actor id must be positive");
            //return false;
        }
        return true;
    }


    //getters

    public int getId(){
        return this.value_num;
    }
    public void setId(String id){
        this.value_str = id;
    }

}
