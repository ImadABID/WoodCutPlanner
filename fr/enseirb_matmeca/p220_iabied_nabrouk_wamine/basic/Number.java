package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Number implements IsValid{
    public int value;

    @Override
    public boolean isValid() {
        if(value < 0)
        {
            return false;
        }
        return true;
    }

}