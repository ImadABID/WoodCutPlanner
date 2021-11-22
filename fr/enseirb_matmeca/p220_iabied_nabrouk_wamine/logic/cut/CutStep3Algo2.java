package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;

import java.util.ArrayList;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Point;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.basic.Rectangle;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;

public class CutStep3Algo2 implements CutAlgos {

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> Panels){

        // To implement later.

        return new ArrayList<Cut>();
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
