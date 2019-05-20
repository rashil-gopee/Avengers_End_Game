package Model;

import java.awt.*;
import java.io.Serializable;

public abstract class Attacker extends Piece implements Serializable {

    public Attacker(int stealth, int attackingPower, int attackingDistance, String image, Player owner){
        super(stealth,  attackingPower,  attackingDistance, image, owner);
    }
}
