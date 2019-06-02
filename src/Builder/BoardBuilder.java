package Builder;

import Factory.AbstractPieceFactory;
import Factory.AttackersPieceFactory;
import Factory.DefendersPieceFactory;
import Model.*;
import Strategy.AttackStrategy;

import java.util.ArrayList;

public class BoardBuilder {
    final static int ATTACKERS_COLUMN=0;
    final static int DEFENDERS_COLUMN=9;

    AbstractPieceFactory attackersPieceFactory=new AttackersPieceFactory();
    AbstractPieceFactory defendersPieceFactory=new DefendersPieceFactory();


    /**
     * This method is used to build the board for the game. This method calls Piece Factory for
     * both attackers and defenders and then setups up the board with those pieces. It then returns
     * the board back to the caller function
     * @param players this is list of players.
     * @param boardSize this is board size to be setup.
     * @param isPowerStrategy this represents the strategy the player has chosen to play.
     * @return Board
     */
    public Board buildBoard(ArrayList<Player> players, int boardSize, boolean isPowerStrategy)
    {
        Directory attackersDirectory = attackersPieceFactory.getPieces(players.get(0),isPowerStrategy);
        Directory defendersDirectory = defendersPieceFactory.getPieces(players.get(1),isPowerStrategy);

        Board board=Board.getInstance(boardSize);

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    board.getHexagon(i, j).setPiece(null);
                }
            }

        int j=0;
        for(int i=0;i<boardSize;i=i+2)
        {
            board.getHexagon(i,ATTACKERS_COLUMN).setPiece(attackersDirectory.get(j));
            j++;
        }
        j=0;
        for(int i=1;i<boardSize;i=i+2)
        {
            board.getHexagon(i,DEFENDERS_COLUMN).setPiece(defendersDirectory.get(j));
            j++;
        }
        return board;
    }



}
