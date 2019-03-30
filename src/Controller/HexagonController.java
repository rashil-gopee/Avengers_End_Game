package Controller;

import Model.Hexagon;

public class HexagonController {
    public void moveHexagaon(Hexagon source, Hexagon target) {
        System.out.println(source);
        System.out.println(target);
        if (source.getPiece() != null && source.getPiece() != target.getPiece()) {
            target.setPiece(source.getPiece());
            source.setPiece(null);
        }
    }
}
