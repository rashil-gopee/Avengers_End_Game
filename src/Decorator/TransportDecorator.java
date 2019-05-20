package Decorator;

import static java.lang.Math.abs;

import Decorator.PieceDecorator;
import Model.Piece;

public class TransportDecorator extends PieceDecorator {
    public TransportDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece);
    }

    @Override
    public void specialEffect(){
        piece.specialEffect();
        transpose();
    }

    public void transpose(){
        System.out.println("I can transpose guys");
    }


}





