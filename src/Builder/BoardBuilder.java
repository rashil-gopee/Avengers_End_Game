package Builder;

import Factory.PieceFactory;
import Model.*;

import java.util.ArrayList;

public class BoardBuilder {

    PieceFactory pieceFactory=new PieceFactory();
    public Board buildBoard(ArrayList<Player> players, AttackersDirectory attackersDirectory, DefendersDirectory defendersDirectory, int boardSize)
    {
//        AttackersDirectory attackersDirectory = pieceFactory.getAttackers(players.get(0));
//        ArrayList<Piece> defenders = pieceFactory.getDefenders(players.get(1));

        Board board=Board.getInstance(boardSize);

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    board.getHexagon(i, j).setPiece(null);
                }
            }

        int j=0;
        for(int i=0;i<boardSize;i=i+2)
        {
            board.getHexagon(i,0).setPiece(attackersDirectory.get(j));
            j++;
        }
        j=0;
        for(int i=1;i<boardSize;i=i+2)
        {
            board.getHexagon(i,9).setPiece(defendersDirectory.get(j));
            j++;
        }
        return board;
    }



}
