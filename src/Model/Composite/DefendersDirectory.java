package Model.Composite;

import java.io.Serializable;

public class DefendersDirectory extends PieceComposite implements Serializable {
    @Override
    public void suffer(int i) {
        pieces.forEach((piece) -> piece.suffer(i));
    }

    @Override
    public void heal(int i) {
        pieces.forEach((piece) -> piece.suffer(i + 1));
    }
}
