package Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance = null;

    private Board board;
    private ArrayList<Player> players;
    private int playerTurn;
    private Hexagon selectedHexagon;
    private int boardSize;

    public int getBoardSize() {
        return boardSize;
    }

    public Board getBoard() {
        return board;
    }
    private List<IModelChangeListener> listeners = new ArrayList<>();

    public int getPlayerTurn() {
        return playerTurn;
    }

    private Game(int numOfPlayers,int boardSize){
        this.players = new ArrayList<>();
        for (int i =0; i < numOfPlayers; i++) {
            this.players.add(new Player("Player " + i + 1 ));
        }
        this.board=new Board(players);
        this.boardSize=boardSize;
        playerTurn = 0;
    }

    public static Game getInstance(int numOfPlayers,int boardSize){
        if (instance == null){
            instance = new Game(numOfPlayers,boardSize);
        }
        return instance;
    }

    public static Game getInstance(){
        if (instance != null){
            return instance;
        }
        return null;
    }
    public Player getPlayer() {
        return players.get(playerTurn);
    }

    public Hexagon getSelectedHexagon() {
        return selectedHexagon;
    }

    public void setSelectedHexagon(Hexagon selectedHexagon) {
        if(selectedHexagon==null||selectedHexagon.getPiece()!=null&&selectedHexagon.getPiece().isOwner(players.get(playerTurn)))
            this.selectedHexagon = selectedHexagon;
    }

    public void changePlayerTurn() {
        if (playerTurn == (players.size() - 1)){
            playerTurn = 0;
        }
        else
            playerTurn = playerTurn + 1;
        this.notifyModelChangedListeners();
    }

    private void notifyModelChangedListeners() {
        this.listeners.forEach(listener -> listener.onModelChange(this));
    }

    public void addModelChangedListeners(IModelChangeListener listener) {
        this.listeners.add(listener);
    }

    public void click(int x, int y) {
        boolean move=false;
        if(getSelectedHexagon()==null)
        {
            setSelectedHexagon(getBoard().getHexagon(x,y));
            return;
        }
        else
        {
            if(getBoard().getHexagon(x,y).getPiece() == null)
                move = getSelectedHexagon().getPiece().move(getSelectedHexagon(), getBoard().getHexagon(x, y));
            else if(!getBoard().getHexagon(x,y).getPiece().isOwner(players.get(playerTurn)))
                move = getSelectedHexagon().getPiece().attack(getSelectedHexagon(), getBoard().getHexagon(x, y));
            if (move) {
                changePlayerTurn();
            }
            setSelectedHexagon(null);
        }
    }
}
