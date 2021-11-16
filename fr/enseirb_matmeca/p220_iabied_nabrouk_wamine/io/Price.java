package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

class Price implements IsValid {

    String value_1;
    Float value_2;
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