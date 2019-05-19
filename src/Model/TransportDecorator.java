package Model;

import static java.lang.Math.abs;

import com.google.java.contract.Requires;

import static java.lang.Math.abs;

public class TransportDecorator extends PieceDecorator{
    public TransportDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece);
    }
    public void transpose(){

        System.out.println("I can transpose guys");

    }


}





