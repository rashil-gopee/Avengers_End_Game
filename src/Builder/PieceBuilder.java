package Builder;

import Decorator.ProximityAttackDecorator;
import Model.Attackers.*;
import Model.Defenders.*;
import Model.Piece;
import Model.Player;

public class PieceBuilder {

    public Piece getIronMan(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new IronMan(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackPanther(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new BlackPanther(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getCaptainMarvel(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new CaptainMarvel(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getDrStrange(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new DrStrange(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getHulk(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new Hulk(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getLoki(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new Loki(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getThanos(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new Thanos(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getKillMonger(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new KillMonger(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getUltron(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new Ultron(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackDwarf(Player player) {
        Piece piece = null;
        try {
            piece = new ProximityAttackDecorator(new BlackDwarf(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

}
