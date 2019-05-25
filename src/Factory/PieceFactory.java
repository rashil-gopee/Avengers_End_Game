package Factory;

import Builder.PieceBuilder;
import Model.AttackersDirectory;
import Model.DefendersDirectory;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

public  class PieceFactory {

    private PieceBuilder pieceBuilder = new PieceBuilder();

    public AttackersDirectory getAttackers(Player player, AttackStrategy attackStrategy)
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


    public DefendersDirectory getDefenders(Player player, AttackStrategy attackStrategy)
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
