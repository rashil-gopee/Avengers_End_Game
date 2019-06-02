package Model;

import Command.Command;
import Composite.CommandComposite;
import Model.Tree.Node;
import Strategy.AttackStrategy;
import Strategy.PowerAttackStategy;
import Strategy.StealthDifferenceAttackStrategy;
import Utilities.FileHelper;
import Builder.BoardBuilder;
import Command.AttackCommand;
import Command.MoveCommand;
import Command.*;
import Interface.IModelChangeListener;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Stack;

public class Game implements Serializable{
    private static Game instance = null;
    private Player playerWon=null;
    private Board board;
    private ArrayList<Player> players;
    private int playerTurn;
    private Hexagon selectedHexagon;
    private int boardSize;
    private CommandComposite commandManager;
    private static final String POWER_STRATEGY = "Power";
    private boolean isPowerAttackStrategy;
    private Node root;
    private Node selectNode;
    private int nodeId;
    private ArrayList<Command> res;
    public static Piece getHexagonPiece(int x, int y) {
           return getInstance().board.getHexagonPiece(x,y);
    }

    public static Hexagon getHexagon(int i, int j) {
        return getInstance().board.getHexagon(i,j);
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

        this.isPowerAttackStrategy = strategy.equals(POWER_STRATEGY);

        BoardBuilder boardBuilder=new BoardBuilder();
        this.board= boardBuilder.buildBoard(players, boardSize,isPowerAttackStrategy);

        this.commandManager=new CommandComposite();
        playerTurn = 0;
        this.root=null;
        this.selectNode=null;
        this.nodeId=0;
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
     * This method is used to decide whether the player selected a piece or
     * has selected a hexagon to perform an action.
     * @param x this is x position of the hexagon.
     * @param y this is y position of the hexagon.
     * @param specialEffect this represents if the player has played a specialEffect.
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
        checkPlayerWon();
    }

    private void checkPlayerWon() {
        Player player=board.getPlayerWon(boardSize);
        if(player!=null){
         this.playerWon=playerWon;
        }
    }

    /**
     * This method is used to decide whether the player has decided to attack , move  or
     * perform special attack and accordingly calls the respective method. It is also responsible
     * for changing the player turn.
     * @param x this is x position of the hexagon.
     * @param y this is y position of the hexagon.
     * @param specialEffect this represents if the player has played a specialEffect.
     * @return void
     */
    @Requires("x>=0 && x<boardSize && y>=0 && y<boardSize")
    @Ensures("selectedHexagon==null || selectedHexagon== getBoard().getHexagon(x,y)")
    private void performAction(int x, int y, boolean specialEffect){
        boolean move=false;
        if (selectedHexagon == getBoard().getHexagon(x,y)) {
            setSelectedHexagon(null);
        }
        else if (specialEffect && !getSelectedHexagon().isSpecialEffectUsed()) {
            CommandComposite commands = new CommandComposite();
            Command command=new MoveCommand(getSelectedHexagon(),board.getHexagon(x, y));

            commands.add(command);
            move= this.commandManager.executeCommand(command);

            if(move) {
                addTree(command);
                getBoard().getHexagon(x,y).getPiece().specialEffect(getBoard().getHexagon(x,y), commands);
                this.commandManager.executeCommand(commands);
            }
        }
        else if(!getBoard().hexagonHasPiece(x,y)) {
            Command command=new MoveCommand(getSelectedHexagon(),board.getHexagon(x, y));
            move= this.commandManager.executeCommand(command);
            if(move)
                addTree(command);
        }
        else if(!getBoard().hexagonHasOwner(x,y,players.get(playerTurn))) {
            Command command=new AttackCommand(getSelectedHexagon(),board.getHexagon(x, y));
            move= this.commandManager.executeCommand(command);
            if(move)
                addTree(command);
            Stack path=new Stack<Node>();

            traverseNode(root,path,2);
        }
        if(move) {
            changePlayerTurn();
        }
        setSelectedHexagon(null);
    }


    /**
     * This method is used to add every command to the tree as a node so that
     * the player can decide to move back to any node and continue a new game from there.
     * @param command this is command to be added into the tree
     * @return void
     */
    @Requires("command!=null")
    @Ensures("root!=null")
    private void addTree(Command command) {
        if(root==null) {
            root = new Node(nodeId,command);
            selectNode=root;
        }
        else
        {
            Node node=new Node(nodeId,command);
            selectNode.addChild(node);
            selectNode=node;
        }
        this.nodeId++;
    }


    /**
     * This method is used to find the node the player wants to go to and then
     * change the board setting based on those commands.
     * @param id this is unique id of the node the player want's to move to.
     * @return void
     */
    @Requires("id>=0")
    public void goToNode(int id)
    {
        Stack path=new Stack<Node>();
        traverseNode(root, path,id);
        playNode();
    }

    public void saveGame()
    {
        FileHelper fileHelper=new FileHelper();
        fileHelper.writeObjectToFile(this);
    }

    /**
     * This method is used to undo the commands for both players. Each player
     * can undo only once during the game. It then notifies to refresh the board.
     * @param undo this is number of undo commands the player wants to do.
     * @return void
     */
    @Requires("undo>0&&undo<=3")
    public void undo(int undo)
    {
        if(players.get(playerTurn).canUndo()) {
            this.commandManager.undoCommand(undo);
            players.get(playerTurn).deactivateUndo();
            if(undo!=2)
                this.changePlayerTurn();
            else
                this.notifyModelChangedListeners();

        }
    }

    /**
     * This is a recursive function which is used to find the path from root node
     * of the tree to a particular unique id. Each node represents command played
     * by the player. This is done so as to reduce the memory footprint.
     * @param root this is root node of the tree.
     * @param path this is a stack of path from root node to the destination node.
     * @param search this is unique id of the node to be searched.
     * @return Stack<Node> this is the path to be traversed.
     */
    public Stack<Node> traverseNode(Node root, Stack<Node> path,int search)
    {

        path.add(root);
        if(root.getId()==search)
        {
            this.selectNode=root;
            res=new ArrayList<Command>();
            for(int i=0;i<path.size();i++)
            {
                res.add(path.get(i).getCommand());
            }
            return path;
        }
        if(root.childCount() == 0) {
            path.pop();
            return null;
        }
        else {
            for(int i=0;i<root.childCount();i++)
            {
                traverseNode(root.getChild(i),path,search);
            }
        }
        path.pop();
        return null;
    }

    /**
     * This method is used to replay all the moves from the start of
     * the game to the present setup for the player to replay the game at any time.
     * @return void
     */
    public void replayAllMoves()
    {
        BoardBuilder boardBuilder=new BoardBuilder();
        this.board= boardBuilder.buildBoard(players, boardSize, isPowerAttackStrategy);
        this.notifyModelChangedListeners();
        this.commandManager.playMoves(this);
    }

    /**
     * This method is used to setup the initial board and then redo the moves from starting
     * to the particular node the user wants to go to.
     * @return void
     */
    public void playNode()
    {
        BoardBuilder boardBuilder=new BoardBuilder();
        this.board= boardBuilder.buildBoard(players, boardSize,isPowerAttackStrategy);
        this.commandManager.playNodeMoves(res);
        this.notifyModelChangedListeners();

    }
}
