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

public class Hulk extends Attacker implements Serializable {
    public Hulk(Player owner) throws Exception{
        super(20, 7, 1, "Images/Hulk.png", owner);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source, Hexagon target) {
        System.out.println("Move Hulk");
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && !(source.getY()-target.getY()>0) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
