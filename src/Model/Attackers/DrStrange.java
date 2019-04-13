package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class DrStrange extends Attacker {
    public DrStrange(Player owner) throws Exception {
        super(20, 5, 2, ImageIO.read(new URL("https://cdn1us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/2016/12/doctor-strange-2-benedict-cumberbatch.jpg?itok=jeAJwK4P")), owner);
    }

    public boolean move(Hexagon source,Hexagon target) {
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece() == null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
