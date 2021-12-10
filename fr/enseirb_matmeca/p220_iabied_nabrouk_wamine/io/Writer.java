package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut.Cut;

import java.util.ArrayList;

public interface Writer {

    public static Writer getWriter(String type) throws IllegalArgumentException {
        if(type == "XML"){
            return new XMLWriter();
        }
        if(type == "SVG"){
            return new SVGWriter();
        }
        throw new IllegalArgumentException("Uknown type.");
    }

    public void write(ArrayList<Cut> cuts, String path);
}
