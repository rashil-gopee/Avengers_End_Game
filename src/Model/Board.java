package Model;

import Model.Attackers.BlackPanther;
import Model.Attackers.CaptainMarvel;
import Model.Attackers.DrStrange;
import Model.Attackers.IronMan;
import Model.Defenders.KillMonger;
import Model.Defenders.Loki;
import Model.Defenders.Thanos;
import Model.Defenders.Ultron;
import View.AvengersGameView;

import java.util.ArrayList;

public class Board {
    final static int BSIZE = 10; //board size.
    //private ArrayList<Player> players;
    AvengersGameView view;
    public Board(ArrayList<Player> players)  {
        //view=new AvengersGameView();
        hexagons = new Hexagon[BSIZE][BSIZE];

        try {
            Piece blankPanther=new BlackPanther(players.get(0));
            Piece captainMarvel=new CaptainMarvel(players.get(0));
            Piece drStrange=new DrStrange(players.get(0));
            Piece ironMan=new IronMan(players.get(0));
            Piece killMonger=new KillMonger(players.get(1));
            Piece loki=new Loki(players.get(1));
            Piece thanos=new Thanos(players.get(1));
            Piece ultron=new Ultron(players.get(1));
            for (int i = 0; i < BSIZE; i++) {
                for (int j = 0; j < BSIZE; j++) {
                        hexagons[i][j] = new Hexagon();
                }
            }
            hexagons[0][0]=new Hexagon(blankPanther);
            hexagons[2][0]=new Hexagon(captainMarvel);
            hexagons[4][0]=new Hexagon(drStrange);
            hexagons[6][0]=new Hexagon(ironMan);

            hexagons[1][9]=new Hexagon(killMonger);
            hexagons[3][9]=new Hexagon(loki);
            hexagons[5][9]=new Hexagon(thanos);
            hexagons[7][9]=new Hexagon(ultron);
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
