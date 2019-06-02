package Model;

import Model.Attackers.*;
import Model.Defenders.*;
import Strategy.AttackStrategy;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
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

    public boolean hexagonHasOwner(int i,int j,Player player)
    {
        return getHexagon(i,j).isOwner(player);
    }
    public static Board getInstance(int boardSize){
        if (instance == null){
            instance = new Board(boardSize);
        }
        return instance;
    }


    public Hexagon getHexagon(int i, int j) {
        return hexagons[i][j];
    }

    public boolean hexagonHasPiece(int x, int y) {
        return getHexagon(x,y).hasPiece();
    }

    public Piece getHexagonPiece(int x, int y) {
        return getHexagon(x,y).getPiece();
    }

    public Player getPlayerWon(int boardSize) {
        ArrayList<Player> playerWon=new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(hexagonHasPiece(i,j))
                {
                    playerWon.add(getHexagon(i,j).getOwner());
                }

            }
        }
        if(playerWon.size()==1)
        {
            return playerWon.get(0);
        }
        return null;
    }

//    public void pieceSpecialEffect(int x, int y) {
//        getHexagon(x,y).pieceSpecialEffect();
//    }
}
