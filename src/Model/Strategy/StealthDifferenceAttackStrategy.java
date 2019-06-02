package Model.Strategy;

import Model.Hexagon;

import java.io.Serializable;

import static java.lang.Math.abs;

public class StealthDifferenceAttackStrategy implements AttackStrategy , Serializable {
    public boolean execute(Hexagon source, Hexagon target){
        if(abs(source.getX()-target.getX()) > source.getPiece().getAttackingDistance()||abs(source.getY()-target.getY()) > source.getPiece().getAttackingDistance())
        {
            return false;
        }

        if (target.getPiece().getStealth() < source.getPiece().getStealth()) {
            target.getPiece().suffer(source.getPiece().getStealth());
            if (target.getPiece().getStealth() <= 0)
                target.setPiece(null);
            return true;
        }
        return false;
    }
}
