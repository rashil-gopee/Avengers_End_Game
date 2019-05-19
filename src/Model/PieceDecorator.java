package Model;

import com.google.java.contract.Requires;

import java.awt.*;

public abstract class PieceDecorator extends Piece{

    protected Piece piece;
    public PieceDecorator(int stealth, int attackingPower, int attackingDistance, Image image, Player owner,Piece piece) {
        super(stealth, attackingPower, attackingDistance, image, owner);
        this.piece=piece;
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source, Hexagon target) {
        return piece.move(source,target);
    }

    @Override
    public void specialEffect(){
        System.out.println("Special Effect");
    }

}
