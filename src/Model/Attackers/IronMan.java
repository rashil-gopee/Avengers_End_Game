package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.Serializable;
import java.net.URL;

import static java.lang.Math.abs;

public class IronMan extends Attacker implements Serializable {
    public IronMan(Player owner) throws Exception {
        super(20, 9, 1,"Images/IronMaN.png", owner);
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
