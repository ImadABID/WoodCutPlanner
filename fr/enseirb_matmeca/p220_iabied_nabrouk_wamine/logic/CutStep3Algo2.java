package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.List;

class CutStep3Algo2 implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> panels){

        ArrayList<Cut> cuts = new ArrayList<Cut>();


        panels.sort(new WoodPieceWidthLengthComparator());
        boards.sort(new WoodPieceWidthLengthComparator());

        Panel panel;

        for(int panels_index = 0; panels_index < panels.size(); panels_index++){

            panel = panels.get(panels_index);

            ArrayList<Cut> pannelCuts = CutStep3Algo2.findBoardsForPanel(panel, (ArrayList<Board>)boards);
            
            cuts.addAll(pannelCuts);


        }

        return cuts;
    }

    protected static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards) throws RuntimeException{

        /*
         * At the cut, the board has the panel's orientation.
        */

        ArrayList<Cut> cuts = new ArrayList<Cut>();

        ArrayList<Cut> right_cuts;
        

        Rectangle panelRect;
        Rectangle boardRect;

        double currentWidth = 0;
        Point cut_position;
        Panel possibleCutZone = panel.deepCopy();

        if(! (possibleCutZone.getPolygon() instanceof Rectangle && panel.getPolygon() instanceof Rectangle)){
            throw new RuntimeException("Polygon must be a Rectangle.");
        }

        Rectangle possibleCutZoneRect;

        panelRect = (Rectangle) panel.getPolygon();

        /*
            Cuts are optimised if their direction is the inverse of the panel's orientation.
            convention :
                panel direction horizontal
                cut direction vertical
        */
        panelRect.setOrientation("horizontal");

        Board board;
        Cut cut;

        for(int bords_index = 0; bords_index < boards.size(); bords_index++){

            board = boards.get(bords_index);

            if( ! (board.getPolygon() instanceof Rectangle)){
                throw new RuntimeException("Polygon must be a Rectangle.");
            }
            boardRect = (Rectangle) board.getPolygon();
            boardRect.setOrientation("horizontal");


            cut_position = new Point(0, currentWidth);

            possibleCutZoneRect = new Rectangle(
                cut_position, 
                panelRect.getDimX()-(cut_position.getX()-panelRect.getLeftTopPt().getX()),
                panelRect.getDimY()-(cut_position.getY()-panelRect.getLeftTopPt().getY()),
                true
            );
            possibleCutZone.setPolygone(possibleCutZoneRect);

            cut = new Cut(panel, board, cut_position.deepCopy());

            if(CutStep3Algo2.isCutPossible(cut, possibleCutZone) && !board.isPulledOut()){

                board.setAsPulledOut();
                cuts.add(cut);

                // cut_direction_vertical is vertical
                cut_position.setX(boardRect.getDimX());
                possibleCutZoneRect = new Rectangle(
                    cut_position, 
                    panelRect.getDimX()-(cut_position.getX()-panelRect.getLeftTopPt().getX()),
                    boardRect.getDimY(),
                    true
                );
                possibleCutZone.setPolygone(possibleCutZoneRect);

                currentWidth += boardRect.getDimY();

                right_cuts = CutStep3Algo1.findBoardsForPanel(possibleCutZone, boards, panelRect.isVertical());

                cuts.addAll(right_cuts);

            }
        }

        return cuts;
    }

    private static boolean isCutPossible(Cut cut, Panel possibleCutZone){

        /*
        *   The possibility of a cut depends on the cut's algo.
        *   That's why this method is implemented here and not in the class Cut.
        */

        /*
         * This method is private and all calls inside this class ensure that 
         * the Polygon of a WoodPiece is a Rectangle.
        */

        Rectangle cutZoneRect = (Rectangle) possibleCutZone.getPolygon();
        Rectangle panelRect = (Rectangle) cut.getPanel().getPolygon();
        Rectangle boardRect = (Rectangle) cut.getBoard().getPolygon();

        /*
        * We ignore board.position. The cut is always preformed from cut.position.
        */
        boardRect.setLeftTopPt(cut.getPosition());

        /*
        * We ignore possibleCutZone.position. The zone always starts from cut.position.
        */
        cutZoneRect.setLeftTopPt(cut.getPosition());

        // Verifing if possibleCutZone is a part of cut.panel
        if(!panelRect.contains(cutZoneRect)){
            return false;
        }

        return cutZoneRect.contains(boardRect);

    }

}
