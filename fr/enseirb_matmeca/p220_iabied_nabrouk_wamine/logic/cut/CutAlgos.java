package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public interface CutAlgos{

    public ArrayList<Cut> optimiseCuts(List<Board> boards, List<Panel> Panels) throws ParserConfigurationException, ParseException, IOException, SAXException;

}