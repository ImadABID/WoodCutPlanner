package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class CutStep2Algo implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> panels)throws ParseException{
        ArrayList<Cut> cuts = new ArrayList<>();
        Cut cut;
        Point position = new Point(0,0);
        ArrayList<Board> corresponding_boards;
        int quantity;

        for (Panel panel : panels) {

            quantity = panel.getNbrPiecesFromType().getNumber();
            corresponding_boards = CorrespondingBoardsForPanel(boards, panel, quantity);
            for (Board corresponding_board : corresponding_boards) {
                cut = new Cut(panel, corresponding_board, position);
                cuts.add(cut);
            }
        }
        return cuts;
    }

    public static ArrayList<Board> CorrespondingBoardsForPanel(List<Board> boards, Panel panel, int quantity) throws ParseException {

        ArrayList<Board> corresponding_boards = new ArrayList<>();
        Rectangle rect = (Rectangle) panel.getPolygon(), b_rect;
        double panel_length = rect.getLength(), panel_width = rect.getWidth();
        double board_length, board_width;
        Board curr_board;
        int panel_quantity = quantity;

        Cut cut;

        for (Board board : boards) {
            curr_board = board;
            if (is_rectangle(curr_board.getPolygon())) {
                System.out.println(curr_board.getNbrPiecesFromType().getNumber());
                b_rect = (Rectangle) curr_board.getPolygon();
                board_length = b_rect.getLength();
                board_width = b_rect.getWidth();

                cut = new Cut(panel, board, new Point(0,0));

                if (panel_length >= board_length && panel_width >= board_width && cut.is_delivery_possible() && panel_quantity > 0 && !curr_board.isPulledOut()) {
                    corresponding_boards.add(curr_board);
                    panel_quantity--;
                    curr_board.setAsPulledOut();
                }
            }

        }

        return corresponding_boards;

    }

    public static boolean is_rectangle(Polygon p){
        return (p instanceof Rectangle);
    }

}
