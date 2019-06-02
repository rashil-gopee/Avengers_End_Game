package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.net.URL;

import static java.lang.Math.abs;

public class BlackPanther extends Attacker implements Serializable {

    public BlackPanther(Player owner, AttackStrategy attackStrategy) throws Exception{
             super(20, 1,"Images/blackPanther.jpg", owner, attackStrategy);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Black Panther");
        if(!(abs(source.getX()-target.getX())>getAttackingDistance() || abs(source.getY()-target.getY())>getAttackingDistance()) && !(abs(source.getX()-target.getX())==0) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
