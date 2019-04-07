package Model;

import Model.Attackers.*;
import Model.Defenders.*;
import View.AvengersGameView;

import java.util.ArrayList;

public class Board {
    final static int BSIZE = 10; //board size.
    private Hexagon[][] hexagons;

    public Board(ArrayList<Player> players)  {
        hexagons = new Hexagon[BSIZE][BSIZE];

        try {
            Piece blankPanther=new BlackPanther(players.get(0));
            Piece captainMarvel=new CaptainMarvel(players.get(0));
            Piece drStrange=new DrStrange(players.get(0));
            Piece ironMan=new IronMan(players.get(0));
            Piece hulk=new Hulk(players.get(0));

            Piece killMonger=new KillMonger(players.get(1));
            Piece loki=new Loki(players.get(1));
            Piece thanos=new Thanos(players.get(1));
            Piece ultron=new Ultron(players.get(1));
            Piece blackDwarf=new BlackDwarf(players.get(1));

            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                        hexagons[i][j] = new Hexagon(i,j);
                }
            }
            hexagons[0][0].setPiece(blankPanther);
            hexagons[2][0].setPiece(captainMarvel);
            hexagons[4][0].setPiece(drStrange);
            hexagons[6][0].setPiece(ironMan);
            hexagons[8][0].setPiece(hulk);

            hexagons[1][9].setPiece(killMonger);
            hexagons[3][9].setPiece(loki);
            hexagons[5][9].setPiece(thanos);
            hexagons[7][9].setPiece(ultron);
            hexagons[9][9].setPiece(blackDwarf);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Hexagon getHexagon(int i, int j) {
        return hexagons[i][j];
    }
}
