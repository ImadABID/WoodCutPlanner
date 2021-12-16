package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Writable;

import java.io.PrintWriter;
import java.util.ArrayList;

class SVGWriter implements Writer{

    public void write(ArrayList<Writable> cuts, String path) {
        try {

            ArrayList<String> fields_first, fields;
            String panel_width, panel_height, board_width, board_height, board_x, board_y;
            Writable cut_first, cut;

            PrintWriter pw;

            ArrayList<Boolean> handled = new ArrayList<Boolean>();
            for(int i = 0; i < cuts.size(); i++){
                handled.add(false);
            }

            for(int i = 0; i < cuts.size(); i++){

                if(! handled.get(i)){
                    
                    handled.set(i, true);
                    
                    cut_first = cuts.get(i);
                    fields_first = cut_first.getFields();

                    board_x = fields_first.get(4);
                    board_y = fields_first.get(5);

                    panel_width = fields_first.get(6);
                    panel_height = fields_first.get(7);

                    board_width = fields_first.get(8);
                    board_height = fields_first.get(9);

                    pw = new PrintWriter(path + "_panel_" + fields_first.get(2) + "." + fields_first.get(3) + ".svg");

                    pw.println("<svg xmlns=\"http://www.w3.org/2000/svg\"");
                    pw.println("    version=\"1.1\" width=\"" + panel_width + "\" height=\"" + panel_height + "\">");
                    pw.println("<rect width=\"" + panel_width + "\" height=\"" + panel_height + "\" fill=\"orange\" stroke=\"black\" />");

                    pw.println("<rect x=\""+ board_x +"\" y=\""+ board_y +"\" width=\"" + board_width + "\" height=\"" + board_height + "\" fill=\"red\" stroke=\"black\" />");

                    for(int j = 0; j < cuts.size(); j++){
                        cut = cuts.get(j);
                        fields = cut.getFields();
                        if(! handled.get(j) && (fields_first.get(2) + "." + fields_first.get(3)).equals(fields.get(2) + "." + fields.get(3))){
                            
                            handled.set(j, true);

                            board_x = fields.get(4);
                            board_y = fields.get(5);

                            board_width = fields.get(8);
                            board_height = fields.get(9);

                            pw.println("<rect x=\""+ board_x +"\" y=\""+ board_y +"\" width=\"" + board_width + "\" height=\"" + board_height + "\" fill=\"red\" stroke=\"black\" />");
                        }
                    }

                    pw.println("</svg>");
                    pw.close();


                }

            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
