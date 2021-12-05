package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.*;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Number;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class CutStep2Algo implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> panels)throws ParserConfigurationException, IOException, SAXException, ParseException{
        ArrayList<Cut> cuts = new ArrayList<Cut>();
        double board_length, board_width, board_surface, panel_length, panel_width, panel_surface;
        Rectangle board_rect,panel_rect;
        Point position = new Point(0,0);
        double nearest_surf;
        Number nbr_pieces;
        String d_client;
        String d_supplier;
        Date recep_date,deliv_date;
        //System.out.println(boards.size());
        for(int i = 0; i<boards.size(); i++) {
            board_rect =(Rectangle)(boards.get(i)).getPolygon();
            board_length=board_rect.getLength();
            board_width = board_rect.getWidth();
            board_surface = board_length * board_width;
            panel_rect = (Rectangle) (panels.get(0)).getPolygon();
            // panel_length=panel_rect.getLenght();
            // panel_width=panel_rect.getWidth();
            nearest_surf = 100000;// panel_length * panel_width;
            // nearest_surf = board_surface;
            d_client = boards.get(i).getCritical_date().getDeadline();
            recep_date = new SimpleDateFormat("dd.MM.yy").parse(d_client);
            // System.out.println(panels.size());
            System.out.println("===============");
            for (int j = 0; j < panels.size(); j++) {
                panel_rect = (Rectangle) (panels.get(j)).getPolygon();
                panel_length = panel_rect.getLength();
                panel_width=panel_rect.getWidth();
                nbr_pieces=panels.get(j).getNbrPiecesFromType();
                System.out.println("values " + nbr_pieces.getNumber());
                d_supplier = panels.get(j).getCritical_date().getDeadline();
                deliv_date = new SimpleDateFormat("dd.MM.yy").parse(d_supplier);
                if (nbr_pieces.getNumber() >0 && deliv_date.before(recep_date) && panel_length>=board_length && panel_width>=board_width){
                    panel_surface = panel_length * panel_width;
                    if (panel_surface<=nearest_surf) {
                        nearest_surf = panel_surface;
                        cuts.add(new Cut(panels.get(j),boards.get(i),position));
                        nbr_pieces.setNumber(nbr_pieces.getNumber()-1);
                        panels.get(j).setNbrPiecesFromType(nbr_pieces);
                        break;
                    }
                }
            }
            //cuts.add(new Cut(panels.get(i),boards.get(i),position));

        }

        return cuts;
    }

}
