package Model;

import Strategy.AttackStrategy;

import java.awt.*;
import java.io.Serializable;

public abstract class Attacker extends Piece implements Serializable {

    public Attacker(int stealth, int attackingPower, int attackingDistance, String image, Player owner, AttackStrategy attackStrategy){
        super(stealth,  attackingPower,  attackingDistance, image, owner, attackStrategy);
    }
}
