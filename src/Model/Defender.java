package Model;

import java.awt.*;
import java.io.Serializable;

public abstract class Defender extends Piece implements Serializable {

    public Defender(int stealth, int attackingPower, int attackingDistance, String image, Player owner){
        super(stealth,  attackingPower,  attackingDistance, image, owner);
    }
}
