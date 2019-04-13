package Model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

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
        this.boardSize=boardSize;
        this.players = new ArrayList<>();
        for (int i =0; i < numOfPlayers; i++) {
            this.players.add(new Player("Player " + i + 1 ));
        }
        this.board= Board.getInstance(players, boardSize);
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
        if(getSelectedHexagon()==null)
        {
            setSelectedHexagon(getBoard().getHexagon(x,y));
        }
        else
        {
            Hexagon targetedHexagon = getBoard().getHexagon(x, y);
            if(getBoard().getHexagon(x,y).getPiece() == null) {
//                move = getSelectedHexagon().getPiece().move(getSelectedHexagon(), getBoard().getHexagon(x, y));
                if (getSelectedHexagon().getPiece().canMove(getSelectedHexagon(), targetedHexagon)) {
                    getSelectedHexagon().movePiece(targetedHexagon);
                    setSelectedHexagon(null);
                    changePlayerTurn();
                }
            }
            else if(!getBoard().getHexagon(x,y).getPiece().isOwner(players.get(playerTurn))) {
                if (getSelectedHexagon().canAttack(targetedHexagon)) {
                    targetedHexagon.getPiece().suffer(getSelectedHexagon().getPiece().getAttackingDistance());
                    if (targetedHexagon.getPiece().getStealth() <= 0) {
                        setSelectedHexagon(null);
                    }
                    changePlayerTurn();
                }
//                move = getSelectedHexagon().getPiece().attack(getSelectedHexagon(), getBoard().getHexagon(x, y));
            }
//            if (move) {
//                changePlayerTurn();
//            }

        }
    }
}
