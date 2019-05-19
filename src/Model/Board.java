package Model;

import Model.Attackers.*;
import Model.Defenders.*;

import java.util.ArrayList;

public class Board {
    private static Board instance = null;

    private Hexagon[][] hexagons;

    private Board(int boardSize)  {
        hexagons = new Hexagon[boardSize][boardSize];
        try {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    hexagons[i][j] = new Hexagon(i,j);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setBoard(ArrayList<Player> players,int boardSize)
    {
        System.out.println("I come here");
        try {

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    hexagons[i][j].setPiece(null);
                }
            }
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

    public static Board getInstance(int boardSize){
        if (instance == null){
            instance = new Board(boardSize);
        }
        return instance;
    }
    public static Board getInstance(ArrayList<Player> players,int boardSize){
        if (instance == null){
            instance = new Board(boardSize);
        }
        return instance;
    }

    public static Board getInstance(){
        if (instance != null){
            return instance;
        }
        return null;
    }

    public Hexagon getHexagon(int i, int j) {
        return hexagons[i][j];
    }
}
