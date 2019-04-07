package Model;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    private int playerTurn;
    Hexagon selectedHexagon;
    public Board getBoard() {
        return board;
    }


    public Game(int numOfPlayers){
        this.players = new ArrayList<>();
        for (int i =0; i < numOfPlayers; i++) {
            this.players.add(new Player("Player " + i + 1 ));
        }
        this.board=new Board(players);
        playerTurn = 0;
    }

    public Hexagon getSelectedHexagon() {
        return selectedHexagon;
    }

    public void setSelectedHexagon(Hexagon selectedHexagon) {
        if(selectedHexagon==null||selectedHexagon.getPiece()!=null&&selectedHexagon.getPiece().isOwner(players.get(playerTurn))) {
            this.selectedHexagon = selectedHexagon;
            return;
        }
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

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void changePlayerTurn() {
        if (playerTurn == (players.size() - 1)){
            playerTurn = 0;
        }
        else
            playerTurn = playerTurn + 1;
    }
}
