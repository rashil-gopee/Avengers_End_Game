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

public class DrStrange extends Attacker implements Serializable {
    public DrStrange(Player owner) throws Exception {
        super(20, 5, 2, "Images/DrStrange.jpg", owner);
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
