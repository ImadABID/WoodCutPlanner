package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Price implements IsValid {

    public String value_1;
    public Float value_2;

    @Override
    public boolean isValid()
    {
        final  String PriceFormat = "^\\d+(\\.\\d\\d)";
        if (!(value_1.matches(PriceFormat)) || value_2 <0) {
            return false;
        }
        return true;

    }

}