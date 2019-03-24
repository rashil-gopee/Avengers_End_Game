package Model;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;

    public Game(){
        this.board = new Board();
        this.players = new ArrayList<>();
    }
}
