package Model;

import com.google.java.contract.Requires;

import static java.lang.Math.abs;

public class FlyDecorator extends PieceDecorator {

    private Piece piece;

    public FlyDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner());
        this.piece=piece;

    }

    public void fly(){

        System.out.println("I can fly guys");

    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source, Hexagon target) {
        if (!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }
}
