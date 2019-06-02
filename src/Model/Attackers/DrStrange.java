package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import Model.Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import java.io.Serializable;

import static java.lang.Math.abs;

public class DrStrange extends Attacker implements Serializable {
    public DrStrange(Player owner, AttackStrategy attackStrategy) throws Exception {
        super(10, 2, "Images/DrStrange.jpg", owner, attackStrategy);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece() == null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
