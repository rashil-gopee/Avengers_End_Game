package Decorator;

import Model.*;

import java.util.ArrayList;

public class ExchangeStealthDecorator extends PieceDecorator {
    public ExchangeStealthDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon){
        piece.specialEffect(hexagon);
        proximityExchangeAttack(hexagon);
    }

    public void proximityExchangeAttack(Hexagon hexagon) {
        System.out.println("This: " + hexagon.getX() + "," + hexagon.getY());

        ArrayList<Hexagon> surroundingHexagons = hexagon.getSurroundHexagons();

        Piece highestStealthPiece = null;
        for (Hexagon hex : surroundingHexagons) {
//            System.out.println(hex.getX() + "," + hex.getY());
//            Piece pieceToAttack = Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece();
//            if (pieceToAttack != null) {
//                System.out.println((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker));
////                if ((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker))
//                pieceToAttack.suffer(2);
//            }
            if (highestStealthPiece == null || (hex.getPiece() != null && hex.getPiece().getStealth() > highestStealthPiece.getStealth()))
                highestStealthPiece = hex.getPiece();
        }

        int currentStealth = getStealth();
        piece.setStealth(highestStealthPiece.getStealth());
        highestStealthPiece.setStealth(currentStealth);

    }
}
