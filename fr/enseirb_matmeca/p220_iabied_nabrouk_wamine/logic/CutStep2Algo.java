package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;
import java.util.List;


class CutStep2Algo implements CutAlgos {

    public ArrayList<Writable> optimiseCuts(ArrayList <Readable> readableBoards, ArrayList <Readable> readablePanels){

        ArrayList<Board> boards = Board.boardsFromReadabls(readableBoards);
        ArrayList<Panel> panels = Panel.panelsFromReadabls(readablePanels);
        ArrayList<Writable> cuts = new ArrayList<>();

        Cut cut;
        Point position = new Point(0,0);
        ArrayList<Board> corresponding_boards;
        int quantity;

        for (Panel panel : panels) {

            quantity = panel.getNbrPiecesFromType().getNumber();
            corresponding_boards = CorrespondingBoardsForPanel(boards, panel, quantity);
            for (Board corresponding_board : corresponding_boards) {
                cut = new Cut(panel, corresponding_board, position);
                cuts.add((Writable) cut);
            }
        }
        return cuts;
    }

    public static ArrayList<Board> CorrespondingBoardsForPanel(List<Board> boards, Panel panel, int quantity){

        ArrayList<Board> corresponding_boards = new ArrayList<>();
        Rectangle rect = panel.getBoundingRect(), b_rect;
        double panel_length = rect.getLength(), panel_width = rect.getWidth();
        double board_length, board_width;
        int panel_quantity = quantity;

        Cut cut;

        for (Board curr_board : boards) {

            b_rect = curr_board.getBoundingRect();
            board_length = b_rect.getLength();
            board_width = b_rect.getWidth();

            cut = new Cut(panel, curr_board, new Point(0,0));

            if (panel_length >= board_length && panel_width >= board_width && cut.is_delivery_possible() && panel_quantity > 0 && !curr_board.isPulledOut()) {
                corresponding_boards.add(curr_board);
                panel_quantity--;
                curr_board.setAsPulledOut();
            }

        }

        return corresponding_boards;

    }

    public static boolean is_rectangle(Polygon p){
        return (p instanceof Rectangle);
    }

}
