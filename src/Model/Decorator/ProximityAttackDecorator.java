package Model.Decorator;

import Model.Command.Command;
import Model.Composite.CommandComposite;
import Model.*;
import Model.Command.*;

public class ProximityAttackDecorator extends PieceDecorator{
    public ProximityAttackDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        piece.specialEffect(hexagon, commands);
        proximityAttack(hexagon, commands);
    }

    /**
     * This method is used to do create a special proximity attack. This move attacks
     * all the opponent pieces which are in the surrounding hexagons.
     * @param hexagon this is hexagon around which the attack takes place .
     * @param commands this is the instance for command stack.
     * @return void
     */
    public void proximityAttack(Hexagon hexagon, CommandComposite commands) {
        Command command = new ProximityAttackCommand(hexagon);
        commands.add(command);
    }
}
