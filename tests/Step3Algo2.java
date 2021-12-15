package tests;

import java.util.ArrayList;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Reader;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.io.Writer;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.CutAlgos;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Readable;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Writable;


public class Step3Algo2{
    public static void main(String[] args){

        // Reading
        Reader xmlReader = Reader.getReader("XML");
        ArrayList <Readable> panels = xmlReader.read("fournisseurs.xml");
        ArrayList <Readable> boards = xmlReader.read("clients.xml");

        // Processing
        CutAlgos algo = CutAlgos.getAlgo("step3.2");
        ArrayList<Writable> cuts = algo.optimiseCuts(boards,panels);

        // Displaying Results
        Writable.printList(cuts);

        // Writing
        Writer xmlWriter = Writer.getWriter("XML");
        xmlWriter.write(cuts, "decoupes.xml");

        // Writing
        Writer svgWriter = Writer.getWriter("SVG");
        svgWriter.write(cuts, "decoupes");

    }
}