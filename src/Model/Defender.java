package Model;

public abstract class Defender extends Piece {
    public Defender(int stealth, int attackingPower, int attackingDistance, Player owner){
        super(stealth,  attackingPower,  attackingDistance, owner);
    }
}
