package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class IronMan extends Attacker {
    public IronMan(Player owner) throws Exception {
        super(100, 9, 1, ImageIO.read(new URL("https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/3/39/AoU_Iron_Man_Mk43_art.png/revision/latest?cb=20150310052243")), owner);
    }

    public void move(Hexagon source,Hexagon target) {
        System.out.println("Move Iron Man");
        System.out.println(target.getPiece());
        System.out.println("source x "+source.getX());
        System.out.println("target x "+target.getX());
        System.out.println("source y "+source.getY());
        System.out.println("target y "+target.getY());
        System.out.println("x "+abs(source.getX()-target.getX()));
        System.out.println("y "+abs(source.getY()-target.getY()));
        if(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance())
        {
            return;
        }
        if(target.getPiece()==null) {
            target.setPiece(source.getPiece());
            source.setPiece(null);

        }
    }

    public void attack(Hexagon hexagon) {

    }
}
