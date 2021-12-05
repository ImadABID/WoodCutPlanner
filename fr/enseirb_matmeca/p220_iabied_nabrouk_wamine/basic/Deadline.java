package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Deadline implements IsValid {
    private String date;

    public Deadline(String date){
        this.date = date;
    }

    public Deadline(){
        this("");
    }

    @Override
    public boolean isValid()
    {
        final  String DateFormat = "^\\d\\d(\\.\\d\\d)(\\.\\d\\d)";
        if (!(date.matches(DateFormat)))
              return date.matches(DateFormat);
        Date thedate = new Date(); // objet date qui contiendra la date d'aujourd'hui
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateNow = formatter.format(thedate);
        String yearNow = dateNow.substring(8, 10);
        String yearCommand = date.substring(6, 8);
        int yearNow2 = Integer.parseInt(yearNow);
        int yearCommand2 = Integer.parseInt(yearCommand);
        if (yearNow2 < yearCommand2){
            return true;
        }
        else if (yearNow2 == yearCommand2){
            String monthNow = dateNow.substring(3, 5);
            String monthCommand = date.substring(3, 5);
            int monthNow2 = Integer.parseInt(monthNow);
            int monthCommand2 = Integer.parseInt(monthCommand);    //Bloc de comparaison des mois si nécessaire
            if (monthNow2 < monthCommand2){
                return true;
            }
            else if (monthNow2 == monthCommand2){
                String dayNow = dateNow.substring(0, 2);
                String dayCommand = date.substring(0, 2);
                int dayNow2 = Integer.parseInt(dayNow);               //Bloc de comparaison des mois si nécessaire
                int dayCommand2 = Integer.parseInt(dayCommand);
                if (dayNow2 <= dayCommand2){
                    return true;
                }

            }

        }
        return false;
    }

    
    //getters & setters

    public String getDeadline(){
        return this.date;
    }
    public void setDeadline(String date){
        this.date = date;
    }

}


