package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;
import Strategy.AttackStrategy;
import com.google.java.contract.Requires;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.Serializable;
import java.net.URL;

import static java.lang.Math.abs;

public class Ultron extends Defender implements Serializable {
    public Ultron(Player owner, AttackStrategy attackStrategy) throws Exception {
        super(5, 1, "Images/ultron.jpeg", owner, attackStrategy);
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
