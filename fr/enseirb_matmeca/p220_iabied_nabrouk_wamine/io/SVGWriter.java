package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Writable;

import java.io.PrintWriter;
import java.util.ArrayList;

public class SVGWriter implements Writer{

     public void write(ArrayList<Writable> cuts, String path) {
         try {
             ArrayList<String> fields;
             double length,width;

            for (Writable cut : cuts) {
                 fields = cut.getFields();
                 length = Double.parseDouble(fields.get(6));
                 width = Double.parseDouble(fields.get(7));
                 System.out.println("length:" + length + "\n");

                PrintWriter pw = new PrintWriter(path + "_cut_" + cuts.indexOf(cut) + ".svg");
                pw.println("<svg xmlns=\"http://www.w3.org/2000/svg\"");
                pw.println("    version=\"1.1\" width=\"300\" height=\"500\" fill=\"red\">");
                pw.println("<rect height=\"" + length + "\" width=\"" + width + "\" fill=\"orange\" />");
                pw.println("</svg>");
                pw.close();

             }

         }catch(Exception e){
             System.out.println(e);
         }
     }
}
