package Model;

import java.awt.*;

public abstract class PieceDecorator extends Piece{

    public PieceDecorator(int stealth, int attackingPower, int attackingDistance, Image image, Player owner) {
        super(stealth, attackingPower, attackingDistance, image, owner);
    }

}
