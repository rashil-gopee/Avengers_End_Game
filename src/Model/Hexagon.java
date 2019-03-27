package Model;

public class Hexagon {

    private int positionX;
    private int positionY;

    private Piece piece;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Hexagon(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
