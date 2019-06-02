package Model.Decorator;

import Model.Hexagon;
import Model.Piece;
import Model.Player;
import Model.Strategy.AttackStrategy;
import com.google.java.contract.Requires;
import Model.Composite.*;

public abstract class PieceDecorator extends Piece {
    protected Piece piece;

    public PieceDecorator(int stealth, int attackingDistance, String image, Player owner, Piece piece, AttackStrategy attackStrategy) {
        super(stealth, attackingDistance, image, owner, attackStrategy);
        this.piece=piece;
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source, Hexagon target) {
        return piece.move(source,target);
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        System.out.println("Special Effect");
    }

}
