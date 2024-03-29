package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import Model.Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import java.io.Serializable;

import static java.lang.Math.abs;

public class IronMan extends Attacker implements Serializable {
    public IronMan(Player owner, AttackStrategy attackStrategy) throws Exception {
        super(5,1,"Images/IronMaN.png", owner, attackStrategy);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Iron Man");
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && (target.getPiece()==null)) {
            source.movePiece(target);
            return true;
        }
        return false;
    }

}
