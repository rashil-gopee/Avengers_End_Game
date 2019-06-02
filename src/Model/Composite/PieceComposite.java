package Model.Composite;

import Model.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class PieceComposite {
    protected List<Piece> pieces= new ArrayList<>();

    public void add(Piece piece) {
        this.pieces.add(piece);
    }

    public Piece get(int i) {
        return pieces.get(i);
    }

    public abstract void suffer(int stealth);
    public abstract void heal(int stealth);
}
