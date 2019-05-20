package Factory;

import Builder.PieceBuilder;
import Model.AttackersDirectory;
import Model.DefendersDirectory;
import Model.Piece;
import Model.Player;

public  class PieceFactory {

    PieceBuilder pieceBuilder = new PieceBuilder();

    public AttackersDirectory getAttackers(Player player)
    {
        AttackersDirectory attackersDirectory=new AttackersDirectory();
        try {
            Piece blankPanther=pieceBuilder.getBlackPanther(player);
            Piece captainMarvel=pieceBuilder.getCaptainMarvel(player);
            Piece drStrange= pieceBuilder.getDrStrange(player);
            Piece ironMan = pieceBuilder.getIronMan(player);
            Piece hulk= pieceBuilder.getHulk(player);

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


    public DefendersDirectory getDefenders(Player player)
    {
        DefendersDirectory defendersDirectory=new DefendersDirectory();
        try {
            Piece killMonger= pieceBuilder.getKillMonger(player);
            Piece loki= pieceBuilder.getLoki(player);
            Piece thanos= pieceBuilder.getThanos(player);
            Piece ultron= pieceBuilder.getUltron(player);
            Piece blackDwarf= pieceBuilder.getBlackDwarf(player);

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
