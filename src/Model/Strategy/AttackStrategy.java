package Model.Strategy;

import Model.Hexagon;

public interface AttackStrategy {
    boolean execute(Hexagon source, Hexagon target);
}
