package Factory;

import Builder.PieceBuilder;
import Model.AttackersDirectory;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

public class AttackersPieceFactory extends AbstractPieceFactory{

    private PieceBuilder pieceBuilder = new PieceBuilder();


    /**
     * This method is used to generate the attacker pieces for the game. This method calls PieceBuilder for
     * to generate the attackers pieces. This returns a list of attackers for the game.
     * @param player this is player to which the pieces belong to.
     * @param isPowerStrategy this represents the strategy the player has chosen to play.
     * @return AttackersDirectory
     */
    public AttackersDirectory getPieces(Player player, boolean isPowerStrategy)
    {
        AttackersDirectory attackersDirectory=new AttackersDirectory();
        try {
            Piece blankPanther=pieceBuilder.getBlackPanther(player, isPowerStrategy);
            Piece captainMarvel=pieceBuilder.getCaptainMarvel(player, isPowerStrategy);
            Piece drStrange= pieceBuilder.getDrStrange(player, isPowerStrategy);
            Piece ironMan = pieceBuilder.getIronMan(player, isPowerStrategy);
            Piece hulk= pieceBuilder.getHulk(player, isPowerStrategy);

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
