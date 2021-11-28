package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Number implements IsValid{
    public int value;

    public Number(int value){
        this.value = value;
    }

    public Number(){
        this(-1);
    }

    @Override
    public boolean isValid() {
        if(value < 0)
        {
            return false;
        }
        return true;
    }

    //getters & setters

    public int getNumber(){
        return this.value;
    }
    public void setNumber(int value){
        this.value = value;
    }

}
