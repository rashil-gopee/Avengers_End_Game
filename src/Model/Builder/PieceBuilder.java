package Model.Builder;

import Model.Decorator.ExchangeStealthDecorator;
import Model.Decorator.ProximityAttackDecorator;
import Model.Decorator.ProximityHealDecorator;
import Model.Attackers.*;
import Model.Defenders.*;
import Model.Piece;
import Model.Player;
import Model.Strategy.AttackStrategy;
import Model.Strategy.PowerAttackStategy;
import Model.Strategy.StealthDifferenceAttackStrategy;

import java.io.Serializable;

public class PieceBuilder implements Serializable {

    public Piece getIronMan(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(9);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityAttackDecorator(new ExchangeStealthDecorator(new IronMan(player, attackStrategy)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackPanther(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(7);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityAttackDecorator(new ExchangeStealthDecorator(new BlackPanther(player, attackStrategy)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getCaptainMarvel(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(4);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ExchangeStealthDecorator(new CaptainMarvel(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getDrStrange(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(5);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityAttackDecorator(new DrStrange(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getHulk(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(7);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityHealDecorator(new Hulk(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getLoki(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(5);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityAttackDecorator(new Loki(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getThanos(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(10);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityHealDecorator(new ExchangeStealthDecorator(new Thanos(player, attackStrategy)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getKillMonger(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(4);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityAttackDecorator(new ExchangeStealthDecorator(new KillMonger(player, attackStrategy)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getUltron(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(6);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ExchangeStealthDecorator(new Ultron(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

    public Piece getBlackDwarf(Player player, boolean isPowerStrategy) {
        Piece piece = null;
        try {
            AttackStrategy attackStrategy;
            if (isPowerStrategy)
                attackStrategy = new PowerAttackStategy(4);
            else
                attackStrategy = new StealthDifferenceAttackStrategy();

            piece = new ProximityHealDecorator(new BlackDwarf(player, attackStrategy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piece;
    }

}
