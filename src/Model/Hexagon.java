package Model;

public class Hexagon {

    private Piece piece;
    private int displayText;

    public Hexagon() {
        this.piece = null;
        this.displayText = 0;
    }

    public Hexagon(Piece piece){
        this.piece = piece;
        this.displayText = (int) 'P';
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getDisplayText() {
        return displayText;
    }

    public void setDisplayText(int displayText) {
        this.displayText = displayText;
    }
}
