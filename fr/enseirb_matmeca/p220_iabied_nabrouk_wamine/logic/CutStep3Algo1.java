package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.List;

public class CutStep3Algo1 implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> panels){

        panels.sort(new WoodPieceLengthWidthComparator());
        boards.sort(new WoodPieceLengthWidthComparator());


        Panel panel;

        ArrayList<Cut> cuts = new ArrayList<Cut>();

        for(int panels_index = 0; panels_index < panels.size(); panels_index++){

            panel = panels.get(panels_index);

            ArrayList<Cut> pannelCuts = CutStep3Algo1.findBoardsForPanel(panel, (ArrayList<Board>)boards);

            cuts.addAll(pannelCuts);

        }

        return cuts;
    }

    public static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards) throws RuntimeException{

        if(! (panel.getPolygon() instanceof Rectangle)){
            throw new RuntimeException("Polygon must be a Rectangle.");
        }

        Rectangle panelRect = (Rectangle) panel.getPolygon();
        boolean isPanelVertical = panelRect.isVertical();

        /*
            Cuts are optimised if their direction is the inverse of the panel's orientation.
        */

        return findBoardsForPanel(panel, boards, !isPanelVertical);

    }

    public static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards, boolean cuts_direction_vertical) throws RuntimeException{

        /*
         * At the cut, the board has the panel's orientation.
        */

        ArrayList<Cut> cuts = new ArrayList<Cut>();
        Point cut_position;
        Board board;
        Cut cut;

        Rectangle panelRect;
        Rectangle boardRect;

        if(! (panel.getPolygon() instanceof Rectangle)){
            throw new RuntimeException("Polygon must be a Rectangle.");
        }

        panelRect = (Rectangle) panel.getPolygon();
        boolean isPanelVertical = panelRect.isVertical();

        cut_position = panelRect.getLeftTopPt().deepCopy();

        for(int bords_index = 0; bords_index < boards.size(); bords_index++){

            board = boards.get(bords_index);

            cut = new Cut(panel, board, cut_position.deepCopy());

            if(CutStep3Algo1.isCutPossible(cut) && !board.isPulledOut()){

                board.setAsPulledOut();
                cuts.add(cut);

                if( ! (board.getPolygon() instanceof Rectangle)){
                    throw new RuntimeException("Polygon must be a Rectangle.");
                }

                boardRect = (Rectangle) board.getPolygon();
                boardRect.setOrientation(isPanelVertical);

                if(cuts_direction_vertical){
                    cut_position.setY(
                        cut_position.getY()
                        + boardRect.getWidth()
                    );
                }else{
                    cut_position.setX(
                        cut_position.getX()
                        + boardRect.getWidth()
                    );
                }

            }
        }

        return cuts;
    }

    private static boolean isCutPossible(Cut cut){
        /*
        *   The possibility of a cut depends on the cut's algo.
        *   That's why this method is implemented here and not in the class Cut.
        */

        /*
         * This method is private and all calls inside this class ensure that 
         * the Polygon of a WoodPiece is a Rectangle.
        */

        Rectangle panelRect = (Rectangle) cut.getPanel().getPolygon();
        Rectangle boardRect = (Rectangle) cut.getBoard().getPolygon();

        /*
        * We ignore board.position. The cut is always preformed from cut.position.
        */
        boardRect.setLeftTopPt(cut.getPosition());

        return panelRect.contains(boardRect);
    }

}
