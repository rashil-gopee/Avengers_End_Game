package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;
import Model.Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import java.io.Serializable;

import static java.lang.Math.abs;

public class KillMonger extends Defender implements Serializable {
    public KillMonger(Player owner, AttackStrategy attackStrategy) throws Exception {
        super(15, 2,"Images/KillMonger.jpg", owner, attackStrategy);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
