package Model;

import Model.Attackers.*;
import Model.Defenders.*;

import java.util.ArrayList;

public  class PieceFactory {

    public ArrayList<Piece>  getAttackers(Player player)
    {
        ArrayList<Piece> attackers=new ArrayList<>();
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

            attackers.add(blankPanther);
            attackers.add(captainMarvel);
            attackers.add(drStrange);
            attackers.add(ironMan);
            attackers.add(hulk);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attackers;
    }


    public  ArrayList<Piece> getDefenders(Player player)
    {
        ArrayList<Piece> defenders=new ArrayList<>();
        try {

            Piece killMonger=new KillMonger(player);
            Piece loki=new Loki(player);
            Piece thanos=new Thanos(player);
            Piece ultron=new Ultron(player);
            Piece blackDwarf=new BlackDwarf(player);



            defenders.add(killMonger);
            defenders.add(loki);
            defenders.add(thanos);
            defenders.add(ultron);
            defenders.add(blackDwarf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defenders;
    }


}
