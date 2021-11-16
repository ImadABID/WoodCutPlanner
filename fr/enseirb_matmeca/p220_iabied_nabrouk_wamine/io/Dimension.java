package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

public class Dimension implements IsValid{
    double length;
    double width;
    @Override
    public boolean isValid()
    {
        if((length < 0) || (width < 0) || (length < width))
        {
            return false;
        }
        return true;
    }
}
