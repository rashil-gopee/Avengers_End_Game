package Decorator;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProximityAttackDecorator extends PieceDecorator{
    public ProximityAttackDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon){
        piece.specialEffect(hexagon);
        proximityAttack(hexagon);
    }

    public void proximityAttack(Hexagon hexagon) {
        System.out.println("This: " + hexagon.getX() + "," + hexagon.getY());

        ArrayList<Hexagon> surroundingHexagons = hexagon.getSurroundHexagons();

        for (Hexagon hex : surroundingHexagons) {
            System.out.println(hex.getX() +"," + hex.getY());
            Piece pieceToAttack = Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece();
            if (pieceToAttack != null) {
                System.out.println((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker));
//                if ((piece instanceof Attacker && pieceToAttack instanceof Defender) || (piece instanceof Defender && pieceToAttack instanceof Attacker))
                    pieceToAttack.suffer(2);
            }
        }

//        if (this.piece instanceof Attacker) {
//            System.out.println("Piece is defender");
//            for (Hexagon hex : hexagons) {
//                System.out.println(hex.getX() +"," + hex.getY());
//                if (Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece() instanceof Defender) {
//                    System.out.println("Defender is suffering");
//                    Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece().suffer(2);
//                }
//            }
//        }
//        else {
//            System.out.println("Piece is defender");
//            for (Hexagon hex : hexagons) {
//                System.out.println(hex.getX() +"," + hex.getY());
//                if (Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece() instanceof Attacker) {
//                    System.out.println("Attacker is suffering");
//                    Game.getInstance().getBoard().getHexagon(hex.getX(), hex.getY()).getPiece().suffer(2);
//                }
//            }
//        }

    }
}
