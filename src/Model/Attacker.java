package Model;

import Model.Strategy.AttackStrategy;


import java.io.Serializable;

public abstract class Attacker extends Piece implements Serializable {

    public Attacker(int stealth, int attackingDistance, String image, Player owner, AttackStrategy attackStrategy){
        super(stealth,  attackingDistance, image, owner, attackStrategy);
    }
}
