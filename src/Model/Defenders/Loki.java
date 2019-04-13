package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class Loki extends Defender {
    public Loki(Player owner) throws Exception{
        super(20, 5, 2, ImageIO.read(new URL("https://cdn1us.denofgeek.com/sites/denofgeekus/files/styles/main_wide/public/loki_8.jpg?itok=hrqRLL8M")), owner);
    }

    @Override
    public boolean canMove(Hexagon source,Hexagon target) {
        return (!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null);
    }

}
