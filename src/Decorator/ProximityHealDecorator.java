package Decorator;

import Composite.CommandComposite;
import Model.*;

import java.util.ArrayList;

public class ProximityHealDecorator extends PieceDecorator {
    public ProximityHealDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        piece.specialEffect(hexagon, commands);
        proximityHeal(hexagon);
    }

    /**
     * This method is used to do create a special proximity heal. This move heals
     * all your pieces which are in the surrounding hexagons.
     * @param hexagon this is hexagon around which the heal takes place .
     * @return void
     */
    public void proximityHeal(Hexagon hexagon) {

        ArrayList<Hexagon> surroundingHexagons = hexagon.getSurroundHexagons();

        for (Hexagon hex : surroundingHexagons) {
            Piece pieceToAttack = Game.getHexagonPiece(hex.getX(), hex.getY());
            if (pieceToAttack != null) {
                pieceToAttack.heal(2);
            }
        }
    }
}
