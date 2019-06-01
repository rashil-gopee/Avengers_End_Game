package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefendersDirectory extends Directory  implements Serializable {
    @Override
    public void suffer(int i) {
        pieces.forEach((piece) -> piece.suffer(i));
    }

    @Override
    public void heal(int i) {
        pieces.forEach((piece) -> piece.suffer(i + 1));
    }
}
