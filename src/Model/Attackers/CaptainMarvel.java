package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class CaptainMarvel extends Attacker {
    public CaptainMarvel(Player owner) throws Exception {
        super(100, 4, 2, ImageIO.read(new URL("https://cdn.vox-cdn.com/thumbor/ZgSb4yv1qtN9vYVfCgSSgnBDWMs=/0x0:1233x1000/1200x800/filters:focal(626x149:822x345)/cdn.vox-cdn.com/uploads/chorus_image/image/63199739/MV5BN2M1NjBmYTAtYmM0OC00Yzk5LWFiMjAtZmFiMjc4YmQ4MmE2XkEyXkFqcGdeQXVyNjczOTE0MzM_._V1_SY1000_CR0_0_1233_1000_AL_.0.jpg")), owner);
    }

    public boolean move(Hexagon source,Hexagon target) {
        System.out.println("Move Captain Marvel");
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

    public void attack(Hexagon hexagon) {

    }
}
