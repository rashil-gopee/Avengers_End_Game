package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

import static java.lang.Math.abs;

public class Thanos extends Defender {
    public Thanos(Player owner) throws Exception {
        super(20, 10, 1, ImageIO.read(new URL("https://cdn.vox-cdn.com/thumbor/S52RPSmNS4cx7i4WR15H0A1jtYY=/0x0:2047x1080/1200x675/filters:focal(931x469:1257x795)/cdn.vox-cdn.com/uploads/chorus_image/image/58644051/InfinityWar5a4bb0e7cdea1.0.jpg")), owner);
    }

    public boolean move(Hexagon source,Hexagon target) {
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }

}
