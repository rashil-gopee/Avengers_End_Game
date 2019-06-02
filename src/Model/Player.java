package Model;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private boolean undo;

    public Player(String name){
        this.name = name;
        this.undo=true;
    }

    public String getName(){
        return name;
    }

    public boolean canUndo(){return this.undo;}

    public void deactivateUndo() {
        this.undo=false;
    }
}
