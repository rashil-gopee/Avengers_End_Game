package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class KillMonger extends Defender {
    public KillMonger(Player owner) throws Exception {
        super(20, 4, 2, ImageIO.read(new URL("https://pixel.nymag.com/imgs/daily/vulture/2018/09/17/17-killmonger-movie.w700.h700.jpg")), owner);
    }

    public boolean move(Hexagon source,Hexagon target) {
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
