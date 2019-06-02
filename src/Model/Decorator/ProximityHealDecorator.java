package Model.Decorator;

import Model.Command.*;
import Model.Composite.CommandComposite;
import Model.*;

public class ProximityHealDecorator extends PieceDecorator {
    public ProximityHealDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        piece.specialEffect(hexagon, commands);
        proximityHeal(hexagon, commands);
    }

    /**
     * This method is used to do create a special proximity heal. This move heals
     * all your pieces which are in the surrounding hexagons.
     * @param hexagon this is hexagon around which the heal takes place .
     * @return void
     */
    public void proximityHeal(Hexagon hexagon, CommandComposite commands) {
        Command command = new ProximityHealCommand(hexagon);
        commands.add(command);
    }
}
