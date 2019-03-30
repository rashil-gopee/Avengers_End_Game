package Model;

import java.util.ArrayList;

public class Board {
    final static int BSIZE = 10; //board size.

    public Board(){
        hexagons = new Hexagon[BSIZE][BSIZE];

        for (int i=0;i<BSIZE;i++) {
            for (int j=0;j<BSIZE;j++) {
                hexagons[i][j] = new Hexagon();
                hexagons[i][j].setDisplayText(0);
            }
        }
    }

    public Hexagon[][] getHexagons() {
        return hexagons;
    }

    public void setHexagons(Hexagon[][] board) {
        this.hexagons = board;
    }

    private Hexagon[][] hexagons;

}
