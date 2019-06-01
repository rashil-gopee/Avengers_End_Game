package Builder;

import Factory.PieceFactory;
import Model.*;
import Strategy.AttackStrategy;

import java.util.ArrayList;

public class BoardBuilder {
    final static int ATTACKERS_COLUMN=0;
    final static int DEFENDERS_COLUMN=9;

    PieceFactory pieceFactory=new PieceFactory();
    public Board buildBoard(ArrayList<Player> players, int boardSize, AttackStrategy attackStrategy)
    {
        AttackersDirectory attackersDirectory = pieceFactory.getAttackers(players.get(0),attackStrategy);
        DefendersDirectory defendersDirectory = pieceFactory.getDefenders(players.get(1),attackStrategy);

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
