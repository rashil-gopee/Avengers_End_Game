package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class Loki extends Defender {
    public Loki(Player owner) throws Exception{
        super(100, 5, 2, ImageIO.read(new URL("https://cdn1us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/loki_8.jpg?itok=hrqRLL8M")), owner);
    }

    public void move(Hexagon source,Hexagon target) {
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
