package Model;

import Strategy.AttackStrategy;
import Strategy.PowerAttackStategy;
import Strategy.StealthDifferenceAttackStrategy;
import Utilities.FileHelper;
import Builder.BoardBuilder;
import Command.AttackCommand;
import Command.MoveCommand;
import Command.CommandManager;
import Interface.IModelChangeListener;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Game implements Serializable{
    private static Game instance = null;

    private Board board;
    private ArrayList<Player> players;
    private int playerTurn;
    private Hexagon selectedHexagon;
    private int boardSize;
    private CommandManager commandManager;

    private AttackStrategy attackStrategy;

    public static Piece getHexagonPiece(int x, int y) {
           return getInstance().board.getHexagonPiece(x,y);
    }

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

    @Requires("numOfPlayers>0 && boardSize>2")
    @Ensures("playerTurn==0 && players!=null")
    private Game(int numOfPlayers,int boardSize,String strategy){

        this.boardSize=boardSize;
        this.players = new ArrayList<>();
        for (int i =0; i < numOfPlayers; i++) {
            this.players.add(new Player("Player " + i + 1 ));
        }
        if(strategy.equals("Power"))
        {
            this.attackStrategy = new PowerAttackStategy();
        }
        else {
             this.attackStrategy = new StealthDifferenceAttackStrategy();
        }

        BoardBuilder boardBuilder=new BoardBuilder();
        this.board= boardBuilder.buildBoard(players, boardSize,this.attackStrategy);

        this.commandManager=new CommandManager();
        playerTurn = 0;
    }

    public static Game getInstance(int numOfPlayers,int boardSize,String strategy){
        if (instance == null){
            instance = new Game(numOfPlayers,boardSize,strategy);
        }
        return instance;
    }

    public static Game getInstance(){
        if (instance != null){
            return instance;
        }
        return null;
    }


    public static void setInstance(Game game)
    {
        instance=game;
    }
    public Player getPlayer() {
        return players.get(playerTurn);
    }

    public Hexagon getSelectedHexagon() {
        return selectedHexagon;
    }


    public void setSelectedHexagon(Hexagon selectedHexagon) {
        if(selectedHexagon==null||selectedHexagon.hasPiece()&&selectedHexagon.isOwner(players.get(playerTurn)))
            this.selectedHexagon = selectedHexagon;
    }

    /**
     * This method is used to change the player turn to next player
     * @return void
     */
    @Ensures("playerTurn<players.size()")
    public void changePlayerTurn() {
        if (playerTurn == (players.size() - 1)){
            playerTurn = 0;
        }
        else
            playerTurn = playerTurn + 1;
        this.notifyModelChangedListeners();
    }

    /**
     * This method is used to inform all the listeners once the model changes
     * @return void
     */
    public void notifyModelChangedListeners() {
        this.listeners.forEach(listener -> listener.onModelChange(this));
    }


    /**
     * This method is used to add the listeners which would be informed once the model changes
     * @param listener This is the observer.
     * @return void
     */
    public void addModelChangedListeners(IModelChangeListener listener) {
        this.listeners.add(listener);
    }


    /**
     * This method is used to decide whether the player has decided to attack or move and accordingly
     * calls the respective method.
     * @param x this is x position of the hexagon.
     * @param y this is y position of the hexagon.
     * @return void
     */
    @Requires("x>=0 && x<boardSize && y>=0 && y<boardSize")
    @Ensures("selectedHexagon==null || selectedHexagon== getBoard().getHexagon(x,y)")
    public void click(int x, int y, boolean specialEffect) {
        if(getSelectedHexagon()==null && !specialEffect)
        {
            setSelectedHexagon(getBoard().getHexagon(x,y));
        }
        else
        {
            performAction(x, y, specialEffect);
        }
    }

    private void performAction(int x, int y, boolean specialEffect){
        boolean move=false;
        if (selectedHexagon == getBoard().getHexagon(x,y)) {
            setSelectedHexagon(null);
        }
        else if (specialEffect && !getSelectedHexagon().isSpecialEffectUsed()) {
            move= this.commandManager.ExecuteCommand(new MoveCommand(getSelectedHexagon(),board.getHexagon(x, y)));
            getBoard().getHexagon(x,y).getPiece().specialEffect(getBoard().getHexagon(x, y));
        }
        else if(!getBoard().hexagonHasPiece(x,y)) {
            move= this.commandManager.ExecuteCommand(new MoveCommand(getSelectedHexagon(),board.getHexagon(x, y)));
        }
        else if(!getBoard().hexagonHasOwner(x,y,players.get(playerTurn))) {
            move= this.commandManager.ExecuteCommand(new AttackCommand(getSelectedHexagon(),board.getHexagon(x, y)));
        }
        if(move) {
            changePlayerTurn();
        }
        setSelectedHexagon(null);
    }


    public void saveGame()
    {
        FileHelper fileHelper=new FileHelper();
        fileHelper.WriteObjectToFile(this);
    }

    public void undo(int undo)
    {
        this.commandManager.Undo(undo);
        this.changePlayerTurn();
    }

    public void replayAllMoves()
    {
        BoardBuilder boardBuilder=new BoardBuilder();
        this.board= boardBuilder.buildBoard(players, boardSize,this.attackStrategy);
        this.notifyModelChangedListeners();
        this.commandManager.playMoves(this);
    }


}
