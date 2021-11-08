package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io;

import java.util.ArrayList;
import java.util.List;


import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Client;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor.Supplier;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.cut.Cut;

public class Communicate {

    // Input
    
    static public List<Client> readClients(String path, String tagName){

        return new ArrayList<Client>();

    }

    static public List<Supplier> readSuppliers(String path, String tagName){

        return new ArrayList<Supplier>();

    }


    // Output

    static public void generateCutsXML(List<Cut> cuts){

    }

    static public void generateCutsSVG(List<Cut> cuts){

    }

}
