package Factory;

import Model.Directory;
import Model.Player;
import Strategy.AttackStrategy;

public abstract class AbstractPieceFactory {

  public abstract Directory getPieces(Player player, AttackStrategy attackStrategy);

}
