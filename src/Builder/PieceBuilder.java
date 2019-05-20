package Builder;

import Model.Attackers.*;
import Model.Defenders.*;
import Decorator.FlyDecorator;
import Model.Piece;
import Model.Player;

public class PieceBuilder {

    public Piece getIronMan(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new IronMan(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackPanther(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new BlackPanther(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getCaptainMarvel(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new CaptainMarvel(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getDrStrange(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new DrStrange(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getHulk(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new Hulk(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getLoki(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new Loki(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getThanos(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new Thanos(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getKillMonger(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new KillMonger(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getUltron(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new Ultron(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackDwarf(Player player) {
        Piece piece = null;
        try {
            piece = new FlyDecorator(new BlackDwarf(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

}
