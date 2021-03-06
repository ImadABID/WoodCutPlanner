package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.Comparator;

public class WoodPieceLengthWidthComparator implements Comparator<WoodPiece> {

    @Override
    public int compare(WoodPiece w1, WoodPiece w2) throws RuntimeException {

        if( ! (w1.getPolygon() instanceof Rectangle && w2.getPolygon() instanceof Rectangle)){
            throw new RuntimeException("Comparing two plygones is not implemented.");
        }

        return Rectangle.compareLexicalOrderLengthWith(
            (Rectangle) w1.getPolygon(),
            (Rectangle) w2.getPolygon()
        );
    }

}