package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.logic;

import java.util.ArrayList;

public interface Writable {

    public ArrayList<String> getFields();

    public String toString();

    public static void printList(ArrayList<Writable> writableList){
        for(int i = 0; i<writableList.size(); i++){
            System.out.println(writableList.get(i));
        }
    }
}
