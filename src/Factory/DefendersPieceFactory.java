package Factory;

import Builder.PieceBuilder;
import Model.DefendersDirectory;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

public class DefendersPieceFactory extends AbstractPieceFactory{

    private PieceBuilder pieceBuilder = new PieceBuilder();

    /**
     * This method is used to generate the defenders pieces for the game. This method calls PieceBuilder for
     * to generate the defenders pieces. This returns a list of defenders for the game.
     * @param player this is player to which the pieces belong to.
     * @param attackStrategy this represents the strategy the player has chosen to play.
     * @return DefendersDirectory
     */
    public DefendersDirectory getPieces(Player player, AttackStrategy attackStrategy)
    {
        DefendersDirectory defendersDirectory=new DefendersDirectory();
        try {
            Piece killMonger= pieceBuilder.getKillMonger(player, attackStrategy);
            Piece loki= pieceBuilder.getLoki(player, attackStrategy);
            Piece thanos= pieceBuilder.getThanos(player, attackStrategy);
            Piece ultron= pieceBuilder.getUltron(player, attackStrategy);
            Piece blackDwarf= pieceBuilder.getBlackDwarf(player, attackStrategy);

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
