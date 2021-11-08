package fr.enseirb_matmeca.p220_iabied_nabrouk_wamine.actor;

import java.util.List;

public abstract class Actor {
    protected int id;

    public int getId(){
        return this.id;
    }

    public static Actor getByIdIfNExistCreateIt(List<? extends Actor> actors, int id) throws IllegalArgumentException{

        if(id < 0){
            throw new IllegalArgumentException();
        }

        // To implement later.
        

        if(actors.get(0) instanceof Client){
            Client e = new Client();
            //actors.add(e);
            return e;
        }else{
            Supplier e = new Supplier();
            //actors.add(e);
            return e;
        }

    }

}
