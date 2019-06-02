package Builder;

import Decorator.ExchangeStealthDecorator;
import Decorator.ProximityAttackDecorator;
import Decorator.ProximityHealDecorator;
import Model.Attackers.*;
import Model.Defenders.*;
import Model.Piece;
import Model.Player;
import Strategy.AttackStrategy;

import java.io.Serializable;

public class PieceBuilder implements Serializable {

    public Piece getIronMan(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new IronMan(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackPanther(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new BlackPanther(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getCaptainMarvel(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new CaptainMarvel(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getDrStrange(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new DrStrange(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getHulk(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new Hulk(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getLoki(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new Loki(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getThanos(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new Thanos(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getKillMonger(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new KillMonger(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getUltron(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new Ultron(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackDwarf(Player player, AttackStrategy attackStrategy) {
        Piece piece = null;
        try {
            piece = new ExchangeStealthDecorator(new BlackDwarf(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

}
