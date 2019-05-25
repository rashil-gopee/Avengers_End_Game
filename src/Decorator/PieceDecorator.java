package Decorator;

import Model.Hexagon;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import java.awt.*;

public abstract class PieceDecorator extends Piece {
    protected Piece piece;

    public PieceDecorator(int stealth, int attackingPower, int attackingDistance, String image, Player owner, Piece piece, AttackStrategy attackStrategy) {
        super(stealth, attackingPower, attackingDistance, image, owner, attackStrategy);
        this.piece=piece;
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source, Hexagon target) {
        return piece.move(source,target);
    }

    @Override
    public void specialEffect(Hexagon hexagon){
        System.out.println("Special Effect");
    }

}
