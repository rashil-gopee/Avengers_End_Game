package Model;


import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.io.Serializable;
import java.util.ArrayList;

public class Hexagon implements Serializable {
    private int x;
    private int y;
    private Piece piece;

    public Hexagon(int x,int y) {
        this.x=x;
        this.y=y;
        this.piece = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOwner(Player player)
    {
        return this.piece.isOwner(player);
    }
    /**
     * This method is used to move a hexagon's piece to another one
     * @param target This is the Hexagon where you want to move the piece to.
     * @return void
     */
    @Requires("piece != null && target.getPiece() == null")
    @Ensures("target.getPiece() != null && piece == null")
    public void movePiece(Hexagon target) {
        target.setPiece(this.piece);
        this.piece = null;
    }

    public boolean isSpecialEffectUsed()
    {
        return this.piece.isSpecialEffectUsed();
    }
    public ArrayList<Hexagon> getSurroundHexagons(){
        ArrayList<Hexagon> surroundingHexagons = new ArrayList<>();

        if (this.getX() - 1 >= 0 && this.getY() -1 >= 0)
            surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX() - 1, this.getY()-1));

        if (this.getX()  >= 0 && this.getY() + 1 <= 9)
            surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX() , this.getY() + 1));

        if (this.getX()-1 >= 0 && this.getY() >= 0)
            surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX()-1, this.getY() ));

        if (this.getX() + 1 <= 9 && this.getY() >= 0)
            surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX() + 1, this.getY()));

        if (this.getX() >= 0 && this.getY() - 1 >= 0)
        surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX(), this.getY() - 1));

        if (this.getX() + 1 <= 9 && this.getY() - 1 >= 0)
            surroundingHexagons.add(Game.getInstance().getBoard().getHexagon(this.getX() + 1, this.getY() -1));

        return surroundingHexagons;
    }

    public boolean hasPiece() {
        return this.piece!=null;
    }

    public boolean hasGreaterStealth(Piece highestStealthPiece) {
        return piece.getStealth()>highestStealthPiece.getStealth();
    }

    public void pieceSpecialEffect() {
        piece.specialEffect(this);
    }
}
