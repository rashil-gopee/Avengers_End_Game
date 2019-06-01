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

    public Board buildBoard(ArrayList<Player> players, int boardSize, AttackStrategy attackStrategy)
    {
        Directory attackersDirectory = attackersPieceFactory.getPieces(players.get(0),attackStrategy);
        Directory defendersDirectory = defendersPieceFactory.getPieces(players.get(1),attackStrategy);

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
