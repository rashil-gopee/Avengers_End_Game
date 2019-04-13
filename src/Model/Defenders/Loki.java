package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;

import static java.lang.Math.abs;

public class Loki extends Defender {
    public Loki(Player owner) throws Exception{
        super(20, 5, 1, ImageIO.read(new File("Images/loki.jpg")), owner);
    }

    @Requires("source!=null && target!=null")
    public boolean move(Hexagon source,Hexagon target) {
        if(!(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance()) && target.getPiece()==null) {
            source.movePiece(target);
            return true;
        }
        return false;
    }


}
