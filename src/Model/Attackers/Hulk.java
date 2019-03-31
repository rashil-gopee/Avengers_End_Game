package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class Hulk extends Attacker {
    public Hulk(Player owner) throws Exception{
        super(100, 7, 1, ImageIO.read(new URL("https://upload.wikimedia.org/wikipedia/en/5/59/Hulk_%28comics_character%29.png")), owner);
    }

    public boolean move(Hexagon source, Hexagon target) {
        System.out.println("Move Hulk");

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
