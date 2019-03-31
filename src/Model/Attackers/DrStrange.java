package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class DrStrange extends Attacker {
    public DrStrange(Player owner) throws Exception {
        super(100, 5, 2, ImageIO.read(new URL("https://cdn1us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/2016/12/doctor-strange-2-benedict-cumberbatch.jpg?itok=jeAJwK4P")), owner);
    }

    public void move(Hexagon source,Hexagon target) {
        System.out.println("Move Dr Strange");
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
