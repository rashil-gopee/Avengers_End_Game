package Model;

import View.AvengersGameView;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    int playerTurn;

    public Board getBoard() {
        return board;
    }

    public Game(ArrayList playerList){
        this.players = playerList;
        this.board=new Board(players);
        playerTurn=0;
    }

    public Player getPlayer() {
        return players.get(playerTurn);
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
}
