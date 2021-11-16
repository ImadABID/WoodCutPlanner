package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;

public class Date implements IsValid{
    public String date;

    @Override
    public boolean isValid()
    {
        final  String DateFormat = "^\\d\\d(\\.\\d\\d)(\\.\\d\\d)";
        return date.matches(DateFormat);

    }
    
}
