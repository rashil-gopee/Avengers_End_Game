package Model.Attackers;

import Model.Attacker;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

public class IronMan extends Attacker {
    public IronMan(Player owner) throws Exception {
        super(100, 10, 3, ImageIO.read(new URL("http://www.pngall.com/wp-content/uploads/2016/06/Superman-Logo-Free-Download-PNG.png")), owner);
    }

    public void move(Hexagon source,Hexagon target) {
        System.out.println("Move Iron Man");
        System.out.println(target.getPiece());

        if(target.getPiece()==null) {
            target.setPiece(source.getPiece());
            source.setPiece(null);

        }
    }

    public void attack(Hexagon hexagon) {

    }
}
