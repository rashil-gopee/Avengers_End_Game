package Model.Factory;

import Model.Builder.PieceBuilder;
import Model.Composite.DefendersDirectory;
import Model.Piece;
import Model.Player;

public class DefendersPieceFactory extends AbstractPieceFactory{

    private PieceBuilder pieceBuilder = new PieceBuilder();

    /**
     * This method is used to generate the defenders pieces for the game. This method calls PieceBuilder for
     * to generate the defenders pieces. This returns a list of defenders for the game.
     * @param player this is player to which the pieces belong to.
     * @param isPowerStrategy this represents the strategy the player has chosen to play.
     * @return DefendersDirectory
     */
    public DefendersDirectory getPieces(Player player, boolean isPowerStrategy)
    {
        DefendersDirectory defendersDirectory=new DefendersDirectory();
        try {
            Piece killMonger= pieceBuilder.getKillMonger(player, isPowerStrategy);
            Piece loki= pieceBuilder.getLoki(player, isPowerStrategy);
            Piece thanos= pieceBuilder.getThanos(player, isPowerStrategy);
            Piece ultron= pieceBuilder.getUltron(player, isPowerStrategy);
            Piece blackDwarf= pieceBuilder.getBlackDwarf(player, isPowerStrategy);

            defendersDirectory.add(killMonger);
            defendersDirectory.add(loki);
            defendersDirectory.add(thanos);
            defendersDirectory.add(ultron);
            defendersDirectory.add(blackDwarf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defendersDirectory;
    }
}
