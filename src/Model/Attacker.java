package Model;

public abstract class Attacker extends Piece {
    public Attacker(int stealth, int attackingPower, int attackingDistance, Player owner){
        super(stealth,  attackingPower,  attackingDistance, owner);
    }
}
