package Model;

import Model.Attackers.*;
import Model.Defenders.*;

import java.util.ArrayList;

public  class PieceFactory {

    public AttackersDirectory getAttackers(Player player)
    {
        AttackersDirectory attackersDirectory=new AttackersDirectory();
        try {
            Piece blankPanther=new BlackPanther(player);
            Piece captainMarvel=new CaptainMarvel(player);
            Piece drStrange=new DrStrange(player);
            Piece ironMan=new IronMan(player);
            Piece hulk=new Hulk(player);
//            Piece flyDecorator=new FlyDecorator(ironMan);
//            ((FlyDecorator)flyDecorator).fly();

            Piece transpose=new TransportDecorator(new FlyDecorator(ironMan));

            ((TransportDecorator) transpose).specialEffect();
//            transpose.

            attackersDirectory.add(blankPanther);
            attackersDirectory.add(captainMarvel);
            attackersDirectory.add(drStrange);
            attackersDirectory.add(ironMan);
            attackersDirectory.add(hulk);

//            attackers.add(blankPanther);
//            attackers.add(captainMarvel);
//            attackers.add(drStrange);
//            attackers.add(ironMan);
//            attackers.add(hulk);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attackersDirectory;
    }


    public  DefendersDirectory getDefenders(Player player)
    {
//        ArrayList<Piece> defenders=new ArrayList<>();
        DefendersDirectory defendersDirectory=new DefendersDirectory();
        try {
            Piece killMonger=new KillMonger(player);
            Piece loki=new Loki(player);
            Piece thanos=new Thanos(player);
            Piece ultron=new Ultron(player);
            Piece blackDwarf=new BlackDwarf(player);

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
