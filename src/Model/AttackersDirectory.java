package Model;

import java.io.Serializable;

public class AttackersDirectory extends PieceComposite implements Serializable {
    @Override
    public void suffer(int i) {
        pieces.forEach((piece) -> piece.suffer(i + 1));
    }

    @Override
    public void heal(int i) {
        pieces.forEach((piece) -> piece.suffer(i));
    }
}
