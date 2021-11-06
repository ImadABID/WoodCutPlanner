package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.cut;


import java.util.List;


import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood.Board;
import fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.wood.Panel;

public interface CutAlgos{

    public List<Cut> optimiseCuts(List<Board> boards, List<Panel> Panels);

}