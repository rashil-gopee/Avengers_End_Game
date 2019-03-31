package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class IronMan extends Attacker {
    public IronMan(Player owner) throws Exception {
        super(20, 9, 1, ImageIO.read(new URL("https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/3/39/AoU_Iron_Man_Mk43_art.png/revision/latest?cb=20150310052243")), owner);
    }

    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Iron Man");
        if(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance())
        {
            return false;
        }
        if(target.getPiece()==null) {
            target.setPiece(source.getPiece());
            source.setPiece(null);
            return true;
        }
        return false;
    }

}
