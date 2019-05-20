package Decorator;

import Model.Piece;

import static java.lang.Math.abs;

public class FlyDecorator extends PieceDecorator {
    public FlyDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece);
    }

    @Override
    public void specialEffect(){
        piece.specialEffect();
        fly();
    }

    public void fly() {
        System.out.println("I can fly guys");
    }
}
