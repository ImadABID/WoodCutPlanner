package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

class CutStep3Algo2 implements CutAlgos {

    public ArrayList<Writable> optimiseCuts(ArrayList <Readable> readableBoards, ArrayList <Readable> readablePanels){

        ArrayList<Writable> cuts = new ArrayList<Writable>();

        ArrayList<Board> boards = Board.boardsFromReadabls(readableBoards);
        ArrayList<Panel> panels = Panel.panelsFromReadabls(readablePanels);

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

    public static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards){

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

        Rectangle possibleCutZoneRect;

        panelRect = panel.getBoundingRect();

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
            
            boardRect = board.getBoundingRect();
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
                possibleCutZone.setBoundingRect(possibleCutZoneRect);

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

        // is_delevery_possible
        if(!cut.is_delivery_possible()){
            return false;
        }

        Rectangle cutZoneRect = possibleCutZone.getBoundingRect();
        Rectangle panelRect = cut.getPanel().getBoundingRect();
        Rectangle boardRect = cut.getBoard().getBoundingRect();

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
