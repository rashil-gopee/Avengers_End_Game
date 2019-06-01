package Factory;

import Builder.PieceBuilder;
import Model.DefendersDirectory;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

public class DefendersPeiceFactory extends AbstractPieceFactory{

    private PieceBuilder pieceBuilder = new PieceBuilder();

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
