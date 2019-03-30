package Model.Defenders;

import Model.Defender;
import Model.Hexagon;
import Model.Player;

import javax.imageio.ImageIO;
import java.net.URL;

public class Loki extends Defender {
    public Loki(Player owner) throws Exception{
        super(100, 10, 3, ImageIO.read(new URL("http://www.pngall.com/wp-content/uploads/2016/06/Superman-Logo-Free-Download-PNG.png")), owner);
    }

    public void move(Hexagon hexagon) {

    }

    public void attack(Hexagon hexagon) {

    }
}
