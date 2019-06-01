package Decorator;

import Model.*;

import java.util.ArrayList;

public class ProximityHealDecorator extends PieceDecorator {
    public ProximityHealDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon){
        piece.specialEffect(hexagon);
        proximityHeal(hexagon);
    }

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
