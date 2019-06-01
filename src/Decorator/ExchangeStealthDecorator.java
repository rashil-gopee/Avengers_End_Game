package Decorator;

import Composite.CommandComposite;
import Model.*;

import java.util.ArrayList;

public class ExchangeStealthDecorator extends PieceDecorator {
    public ExchangeStealthDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        piece.specialEffect(hexagon, commands);
        proximityExchangeAttack(hexagon);
    }


    public void proximityExchangeAttack(Hexagon hexagon) {

        ArrayList<Hexagon> surroundingHexagons = hexagon.getSurroundHexagons();

        Piece highestStealthPiece = null;
        for (Hexagon hex : surroundingHexagons) {
            if (highestStealthPiece == null || (hex.getPiece() != null && hex.hasGreaterStealth( highestStealthPiece)))
                highestStealthPiece = hex.getPiece();
        }

        int currentStealth = getStealth();
        piece.setStealth(highestStealthPiece.getStealth());
        highestStealthPiece.setStealth(currentStealth);

    }
}
