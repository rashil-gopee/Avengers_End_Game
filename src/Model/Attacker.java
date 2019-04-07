package Model;

import java.awt.*;

public abstract class Attacker extends Piece {
    public Attacker(int stealth, int attackingPower, int attackingDistance, Image image, Player owner){
        super(stealth,  attackingPower,  attackingDistance, image, owner);
    }
}
