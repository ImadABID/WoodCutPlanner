package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

public interface CutAlgos{

    public static CutAlgos getAlgo(String algo) throws IllegalArgumentException{
        switch(algo){

            case "step2":
                return new CutStep2Algo();

            case "step3.1":
                return new CutStep3Algo1();
            
            case "step3.2":
                return new CutStep3Algo2();

            case "step4":
                return new CutStep4Algo();

            default:
                throw new IllegalArgumentException("Uknown Algo.");

        }
    }

    public ArrayList<Writable> optimiseCuts(ArrayList <Readable> readableBoards, ArrayList <Readable> readablePanels);

}