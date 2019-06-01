package Model;

import Strategy.AttackStrategy;

import java.io.Serializable;

public abstract class Defender extends Piece implements Serializable {

    public Defender(int stealth, int attackingPower, int attackingDistance, String image, Player owner, AttackStrategy attackStrategy){
        super(stealth,  attackingPower,  attackingDistance, image, owner, attackStrategy);
    }
}
