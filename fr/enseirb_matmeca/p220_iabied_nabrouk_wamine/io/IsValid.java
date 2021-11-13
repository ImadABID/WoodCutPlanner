package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface IsValid {
    public static void isPositive(int number, String item) {
        if (number < 0){
            throw new IllegalArgumentException(item + " must be positive : " + number);
        }
    }

    public static void isPositive(float number, String item) {
        if (number < 0){
            throw new IllegalArgumentException(item + " must be positive : " + number);
        }
    }

    public static void isDimension(float length, float width){
        if (length < width){
            throw new IllegalArgumentException("length " + length +" must be greater than width " + width);
        }

    }
    public static void isDateFormat(String date){
        final  String DateFormat = "^\\d\\d(\\.\\d\\d)(\\.\\d\\d)";
        if (!(date.matches(DateFormat))) {
            throw new IllegalArgumentException("Invalid Date Format : " + date);
        }
    }
    public static void isFutureDate(String date) throws ParseException {
      //  SimpleDateFormat dformat = new SimpleDateFormat("yy.mm.dd");
      //  Date commandDate = dformat.parse(date);
      //  Date dateNow = dformat.parse(String.valueOf(java.time.LocalDate.now()));
      //  if (commandDate.compareTo(dateNow) < 0) {
      //      throw new IllegalArgumentException("Invalid Date in tha past : " + date);
      //  }

    }
    public static void isPriceFormat(String price){
        final  String PriceFormat = "^\\d+(\\.\\d\\d)";
        if (!(price.matches(PriceFormat))) {
            throw new IllegalArgumentException("Invalid Price Format : " + price);
        }
    }

}
