package Model;

import View.AvengersGameView;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;

    public Board getBoard() {
        return board;
    }

    public Game(ArrayList playerList){
        this.players = playerList;
        this.board=new Board(players);
    }
}
