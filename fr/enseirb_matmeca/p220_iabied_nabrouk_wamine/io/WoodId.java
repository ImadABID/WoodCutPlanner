package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

public class WoodId implements IsValid{
    int value;
    @Override
    public boolean isValid() {
        if(value < 0)
        {
            return false;
        }
        return true;
    }
}
