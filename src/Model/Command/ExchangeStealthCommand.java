package Model.Command;

import Model.Hexagon;
import Model.Piece;

import java.util.ArrayList;

public class ExchangeStealthCommand extends Command {
    private Hexagon executionLocation;

    public ExchangeStealthCommand(Hexagon executionLocation) {
        this.executionLocation = executionLocation;
    }

    public boolean execute()
    {
        ArrayList<Hexagon> surroundingHexagons = executionLocation.getSurroundHexagons();

        Piece highestStealthPiece = null;
        for (Hexagon hex : surroundingHexagons) {
            if (highestStealthPiece == null || (hex.getPiece() != null && hex.hasGreaterStealth( highestStealthPiece)))
                highestStealthPiece = hex.getPiece();
        }

        int currentStealth = executionLocation.getPiece().getStealth();
        executionLocation.getPiece().setStealth(highestStealthPiece.getStealth());
        highestStealthPiece.setStealth(currentStealth);
        return true;
    }

    public void undo(){
        ArrayList<Hexagon> surroundingHexagons = executionLocation.getSurroundHexagons();

        Piece lowestStealthPiece = null;
        for (Hexagon hex : surroundingHexagons) {
            if (lowestStealthPiece == null || (hex.getPiece() != null && hex.getPiece().getStealth() < lowestStealthPiece.getStealth()))
                lowestStealthPiece = hex.getPiece();
        }

        int currentStealth = executionLocation.getPiece().getStealth();
        executionLocation.getPiece().setStealth(lowestStealthPiece.getStealth());
        lowestStealthPiece.setStealth(currentStealth);
    }

    public void redo(){
        execute();
    }
}
