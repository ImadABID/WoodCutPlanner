package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Id implements IsValid{
    public int value;

    public Id(int value){
        this.value = value;
    }

    public Id(){
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

}
