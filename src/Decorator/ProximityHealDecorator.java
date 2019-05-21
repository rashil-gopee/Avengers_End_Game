package Decorator;

import Model.*;

import java.util.ArrayList;

public class ProximityHealDecorator extends PieceDecorator {
    public ProximityHealDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece);
    }

    @Override
    public void specialEffect(Hexagon hexagon){
        piece.specialEffect(hexagon);
        proximityHeal(hexagon);
    }

    public void proximityHeal(Hexagon hexagon) {
        System.out.println("This: " + hexagon.getX() + "," + hexagon.getY());

        ArrayList<Hexagon> surroundingHexagons = new ArrayList<>();

        surroundingHexagons.add(new Hexagon(hexagon.getX() - 1, hexagon.getY()));
        surroundingHexagons.add(new Hexagon(hexagon.getX() - 1, hexagon.getY() + 1));
        surroundingHexagons.add(new Hexagon(hexagon.getX(), hexagon.getY() + 1));
        surroundingHexagons.add(new Hexagon(hexagon.getX() + 1, hexagon.getY()));
        surroundingHexagons.add(new Hexagon(hexagon.getX(), hexagon.getY() - 1));
        surroundingHexagons.add(new Hexagon(hexagon.getX() + 1, hexagon.getY() + 1));

        for (Hexagon hex : surroundingHexagons) {
            System.out.println(hex.getX() +"," + hex.getY());
            Piece pieceToAttack = Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece();
            if (pieceToAttack != null) {
                System.out.println((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker));
//                if ((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker))
                pieceToAttack.heal(2);
            }
        }
    }
}
