package Command;

import Model.Hexagon;
import Model.Piece;

import java.io.Serializable;

public class SpecialEffectCommand implements Serializable {
    Piece piece;
    Hexagon previousPosition;
    Hexagon currentLocation;


}
