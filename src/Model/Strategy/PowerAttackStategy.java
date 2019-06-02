package Model.Strategy;

import Model.Hexagon;

import java.io.Serializable;

import static java.lang.Math.abs;

public class PowerAttackStategy implements AttackStrategy, Serializable {
    private int attackingPower;

    public PowerAttackStategy(int attackingPower) {
        this.attackingPower = attackingPower;
    }

    public int getAttackingPower(){
        return attackingPower;
    }

    public boolean execute(Hexagon source, Hexagon target){
        if(abs(source.getX()-target.getX()) > source.getPiece().getAttackingDistance()||abs(source.getY()-target.getY()) > source.getPiece().getAttackingDistance())
        {
            return false;
        }
        target.getPiece().suffer(attackingPower);
        if(target.getPiece().getStealth() <= 0)
            target.setPiece(null);
        return true;
    }
}
