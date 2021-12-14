package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;


import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.WoodPiece;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Readable;

import java.util.ArrayList;

public interface Reader {

    public static Reader getReader(String type) throws IllegalArgumentException {
        if(type == "XML"){
            return new XMLReader();
        }

        throw new IllegalArgumentException("Uknown type.");
    }

    public ArrayList<Readable> read(String path);

}
