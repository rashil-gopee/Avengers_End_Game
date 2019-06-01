package Factory;

import Builder.PieceBuilder;
import Model.AttackersDirectory;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

public class AttackersPieceFactory extends AbstractPieceFactory{

    private PieceBuilder pieceBuilder = new PieceBuilder();

    public AttackersDirectory getPieces(Player player, AttackStrategy attackStrategy)
    {
        AttackersDirectory attackersDirectory=new AttackersDirectory();
        try {
            Piece blankPanther=pieceBuilder.getBlackPanther(player, attackStrategy);
            Piece captainMarvel=pieceBuilder.getCaptainMarvel(player, attackStrategy);
            Piece drStrange= pieceBuilder.getDrStrange(player, attackStrategy);
            Piece ironMan = pieceBuilder.getIronMan(player, attackStrategy);
            Piece hulk= pieceBuilder.getHulk(player, attackStrategy);

            attackersDirectory.add(blankPanther);
            attackersDirectory.add(captainMarvel);
            attackersDirectory.add(drStrange);
            attackersDirectory.add(ironMan);
            attackersDirectory.add(hulk);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attackersDirectory;
    }

}
