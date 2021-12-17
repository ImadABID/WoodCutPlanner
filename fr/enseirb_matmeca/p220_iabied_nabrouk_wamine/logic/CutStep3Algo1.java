package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

class CutStep3Algo1 implements CutAlgos {

    public ArrayList<Writable> optimiseCuts(ArrayList <Readable> readableBoards, ArrayList <Readable> readablePanels){

        ArrayList<Board> boards = Board.boardsFromReadabls(readableBoards);
        ArrayList<Panel> panels = Panel.panelsFromReadabls(readablePanels);
        
        panels.sort(new WoodPieceLengthWidthComparator());
        boards.sort(new WoodPieceLengthWidthComparator());


        Panel panel;

        ArrayList<Writable> cuts = new ArrayList<Writable>();

        for(int panels_index = 0; panels_index < panels.size(); panels_index++){

            panel = panels.get(panels_index);

            ArrayList<Cut> pannelCuts = CutStep3Algo1.findBoardsForPanel(panel, (ArrayList<Board>)boards);

            cuts.addAll(pannelCuts);

        }

        return cuts;
    }

    public static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards){


        Rectangle panelRect = panel.getBoundingRect();
        boolean isPanelVertical = panelRect.isVertical();

        /*
            Cuts are optimised if their direction is the inverse of the panel's orientation.
        */

        return findBoardsForPanel(panel, boards, !isPanelVertical);

    }

    public static ArrayList<Cut> findBoardsForPanel(Panel panel, ArrayList<Board> boards, boolean cuts_direction_vertical){

        /*
         * At the cut, the board has the panel's orientation.
        */

        ArrayList<Cut> cuts = new ArrayList<Cut>();
        Point cut_position;
        Board board;
        Cut cut;

        Rectangle panelRect;
        Rectangle boardRect;

        panelRect = panel.getBoundingRect();
        boolean isPanelVertical = panelRect.isVertical();

        cut_position = panelRect.getLeftTopPt().deepCopy();

        for(int bords_index = 0; bords_index < boards.size(); bords_index++){

            board = boards.get(bords_index);

            cut = new Cut(panel, board, cut_position.deepCopy());

            if(CutStep3Algo1.isCutPossible(cut) && !board.isPulledOut()){

                board.setAsPulledOut();
                cuts.add(cut);

                boardRect = board.getBoundingRect();
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

        // is_delevery_possible
        if(!cut.is_delivery_possible()){
            return false;
        }

        Rectangle panelRect = cut.getPanel().getBoundingRect();
        Rectangle boardRect = cut.getBoard().getBoundingRect();

        /*
        * We ignore board.position. The cut is always preformed from cut.position.
        */
        boardRect.setLeftTopPt(cut.getPosition());

        return panelRect.contains(boardRect);
    }

}
