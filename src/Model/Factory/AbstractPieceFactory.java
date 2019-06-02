package Model.Factory;

import Model.Composite.PieceComposite;
import Model.Player;

public abstract class AbstractPieceFactory {

  public abstract PieceComposite getPieces(Player player, boolean isPowerStrategy);

}
