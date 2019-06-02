package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;
import Model.Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import java.io.Serializable;

import static java.lang.Math.abs;

public class BlackDwarf extends Defender implements Serializable {

    public BlackDwarf(Player owner, AttackStrategy attackStrategy) throws Exception {
        super(20, 2,"Images/BlackDwarf.jpg", owner, attackStrategy);
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
