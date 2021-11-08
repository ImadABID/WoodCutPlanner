package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.cut;


import java.util.List;

import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic.Panel;

public interface CutAlgos{

    public List<Cut> optimiseCuts(List<Board> boards, List<Panel> Panels);

}