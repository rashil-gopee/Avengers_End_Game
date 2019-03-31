package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class CaptainMarvel extends Attacker {
    public CaptainMarvel(Player owner) throws Exception {
        super(100, 4, 2, ImageIO.read(new URL("http://www.pngall.com/wp-content/uploads/2016/06/Superman-Logo-Free-Download-PNG.png")), owner);
    }

    public void move(Hexagon source,Hexagon target) {
        System.out.println("Move Captain Marvel");
        System.out.println(target.getPiece());
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
