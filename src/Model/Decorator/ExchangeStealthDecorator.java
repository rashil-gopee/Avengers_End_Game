package Model.Decorator;

import Model.Command.*;
import Model.Composite.CommandComposite;
import Model.*;

public class ExchangeStealthDecorator extends PieceDecorator {
    public ExchangeStealthDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
    }

    @Override
    public void specialEffect(Hexagon hexagon, CommandComposite commands){
        piece.specialEffect(hexagon, commands);
        proximityExchangeAttack(hexagon, commands);
    }


    public void proximityExchangeAttack(Hexagon hexagon, CommandComposite commands) {
        Command command = new ExchangeStealthCommand(hexagon);
        commands.add(command);
    }
}
