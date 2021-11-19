package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import java.util.ArrayList;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.comparator.WoodPieceLengthWidthComparator;

public class CutStep3Algo1 implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> panels){

        panels.sort(new WoodPieceLengthWidthComparator());
        boards.sort(new WoodPieceLengthWidthComparator());

        int panels_index = 0;
        int bords_index;
        Point cut_position;
        Panel panel;
        Board board;
        Cut cut;

        ArrayList<Cut> cuts = new ArrayList<Cut>();

        while(panels_index < panels.size()){


            panel = panels.get(panels_index);
            
            cut_position = new Point(0, 0);

            bords_index = 0;
            
            while(bords_index < boards.size()){

                board = boards.get(bords_index);

                cut = new Cut(panel, board, cut_position);

                if(CutStep3Algo1.isCutPossible(cut) && !board.isPulledOut()){

                    board.setAsPulledOut();
                    cuts.add(cut);

                    cut_position.setY(
                        cut_position.getY()
                        + ((Rectangle) board.getPolygon()).getWidth()
                        /*
                        * The Polygon is a Rectangle for sure,
                        * otherwise a runtime exception should have been raised at the sort stage.
                        */
                    );

                }

                bords_index++;

            }

            panels_index++;
        }

        return cuts;
    }

    private static boolean isCutPossible(Cut cut){
        /*
        *   The possibility of a cut depends on the cut's algo.
        *   That's why this method is implemented here and not in the class Cut.
        */


        double bl = ( (Rectangle) cut.getBoard().getPolygon()).getWidth();
        double bL = ( (Rectangle) cut.getBoard().getPolygon()).getLength();

        double pl = ( (Rectangle) cut.getBoard().getPolygon()).getWidth() - cut.getPosition().getY();
        double pL = ( (Rectangle) cut.getBoard().getPolygon()).getLength();

        /*
         * This method is private and all calls inside this class ensure that 
         * the Polygon of a WoodPiece is a Rectangle.
        */

        return pl>=bl && pL >= bL;
    }

}
