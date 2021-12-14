package tests;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Reader;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Readable;

public class Step1{
    public static void main(String[] args) {

        Reader xmlReader = Reader.getReader("XML");

        
        ArrayList <Readable> panels = xmlReader.read("fournisseurs.xml");
        Readable.printList(panels);

        ArrayList <Readable> boards = xmlReader.read("clients.xml");
        Readable.printList(boards);


    }
}