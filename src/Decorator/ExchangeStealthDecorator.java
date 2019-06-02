package Decorator;

import Command.*;
import Composite.CommandComposite;
import Model.*;

import java.util.ArrayList;

public class ExchangeStealthDecorator extends PieceDecorator {
    public ExchangeStealthDecorator(Piece piece)
    {
        super(piece.getStealth(),piece.getAttackingPower(),piece.getAttackingDistance(),piece.getImage(),piece.getOwner(),piece, piece.getAttackStrategy());
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
