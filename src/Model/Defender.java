package Model;

import Model.Strategy.AttackStrategy;

import java.io.Serializable;

public abstract class Defender extends Piece implements Serializable {

    public Defender(int stealth, int attackingDistance, String image, Player owner, AttackStrategy attackStrategy){
        super(stealth,  attackingDistance, image, owner, attackStrategy);
    }
}
