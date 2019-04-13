package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;

import static java.lang.Math.abs;

public class CaptainMarvel extends Attacker {
    public CaptainMarvel(Player owner) throws Exception {
        super(20, 4, 2, ImageIO.read(new File("Images/CaptainMarvel.jpg")), owner);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Captain Marvel");
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
