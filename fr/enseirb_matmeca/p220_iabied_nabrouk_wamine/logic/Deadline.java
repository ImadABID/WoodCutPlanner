package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


class Deadline implements BasicObject {
    
    private String date;
    private boolean isValid = false;

    public Deadline(String date){

        try{

            this.date = date;
            

            // verifying date format
            if (!(date.matches("^\\d\\d(\\.\\d\\d)(\\.\\d\\d)"))){
                throw new RuntimeException("Invalid Date format.");
            }

            // Verifying if deadline is in the future.
            if( ! this.isInTheFuture()){
                throw new RuntimeException("Deadline has already passed.");
            }


            this.isValid = true;


        }catch (Exception e) {
            this.isValid = false;
            System.out.println(e);
        }

    }

    public Deadline(ArrayList<String> paramList){

        if(paramList.size() != 1){
            throw new RuntimeException("paramList is not conform.");
        }

        try{

            this.date = paramList.get(0);
            

            // verifying date format
            if (!(date.matches("^\\d\\d(\\.\\d\\d)(\\.\\d\\d)"))){
                throw new RuntimeException("Invalid Date format.");
            }

            // Verifying if deadline is in the future.
            if( ! this.isInTheFuture()){
                throw new RuntimeException("Deadline has already passed.");
            }


            this.isValid = true;


        }catch (Exception e) {
            this.isValid = false;
            System.out.println(e);
        }
    }

    @Override
    public boolean isValid()
    {
        return this.isValid;
    }

    public boolean isInTheFuture(){

        Date thedate = new Date(); // objet date qui contiendra la date d'aujourd'hui
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateNow = formatter.format(thedate);

        String yearNow = dateNow.substring(8, 10);
        String yearCommand = this.date.substring(6, 8);
        int yearNow2 = Integer.parseInt(yearNow);
        int yearCommand2 = Integer.parseInt(yearCommand);

        if (yearNow2 < yearCommand2){
            return true;
        }else if (yearNow2 == yearCommand2){

            String monthNow = dateNow.substring(3, 5);
            String monthCommand = date.substring(3, 5);
            int monthNow2 = Integer.parseInt(monthNow);
            int monthCommand2 = Integer.parseInt(monthCommand);    //Bloc de comparaison des mois si nécessaire
            
            if (monthNow2 < monthCommand2){

                return true;

            }else if (monthNow2 == monthCommand2){
                
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

}
