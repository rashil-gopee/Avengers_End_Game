package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

import static java.lang.Math.abs;

public class BlackPanther extends Attacker {
    public BlackPanther(Player owner) throws Exception{
            super(20, 7, 1, ImageIO.read(new URL("https://blogs.lcms.org/wp-content/uploads/2018/02/Black-Panther-770x514.jpg")), owner);
    }

    @Requires("source==null")
    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Black Panther");
        if(!(abs(source.getX()-target.getX())>getAttackingDistance() || abs(source.getY()-target.getY())>getAttackingDistance()) && !(abs(source.getX()-target.getX())==0) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
