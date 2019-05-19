package Model;

import java.util.ArrayList;

public class BoardBuilder {

    PieceFactory pieceFactory=new PieceFactory();
    public Board buildBoard(ArrayList<Player> players,int boardSize)
    {

        ArrayList<Piece> attackers = pieceFactory.getAttackers(players.get(0));
        ArrayList<Piece> defenders = pieceFactory.getDefenders(players.get(1));
        Board board=Board.getInstance(boardSize);
        int j=0;
        for(int i=0;i<boardSize;i=i+2)
        {
            board.getHexagon(i,0).setPiece(attackers.get(j));
            j++;
        }
        j=0;
        for(int i=1;i<boardSize;i=i+2)
        {
            board.getHexagon(i,9).setPiece(defenders.get(j));
            j++;
        }

        return board;
    }



}
