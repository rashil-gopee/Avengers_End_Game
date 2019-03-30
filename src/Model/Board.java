package Model;

import Model.Attackers.BlackPanther;

import java.util.ArrayList;

public class Board {
    final static int BSIZE = 10; //board size.
    private ArrayList<Player> players;

    public Board(){
        players = new ArrayList<>();
        players.add(new Player("Player 1"));
        hexagons = new Hexagon[BSIZE][BSIZE];

        try {

            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {

                    if (i == 1 && j == 1)
                        hexagons[i][j] = new Hexagon(new BlackPanther(players.get(0)));
                    else
                        hexagons[i][j] = new Hexagon();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Hexagon[][] getHexagons() {
        return hexagons;
    }

    public void setHexagons(Hexagon[][] board) {
        this.hexagons = board;
    }

    private Hexagon[][] hexagons;

    public Hexagon getHexagon(int i, int j) {
        return hexagons[i][j];
    }

}
