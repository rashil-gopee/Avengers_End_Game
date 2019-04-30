package Model;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import java.awt.*;

import static java.lang.Math.abs;

public abstract class Piece {
    private int stealth;
    private int attackingPower;
    private int attackingDistance;
    private Image image;
    private Player owner;

    public Piece(int stealth, int attackingPower, int attackingDistance, Image image, Player owner) {
        this.stealth = stealth;
        this.attackingPower = attackingPower;
        this.attackingDistance = attackingDistance;
        this.image = image;
        this.owner = owner;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getStealth() {
        return stealth;
    }

    public int getAttackingPower() {
        return attackingPower;
    }

    public int getAttackingDistance() {
        return attackingDistance;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Image getImage() {
        return image;
    }

    public abstract boolean move(Hexagon source,Hexagon target);


    /**
     * This method is used to for attacking a hexagon's piece
     * @param source This is the selected hexagon by the player which contains the piece he wants to move
     * @param target  This is the targeted hexagon which contains the piece the player wants to attack
     * @return boolean This returns if the player was allowed and succeeded to attack this the targeted hexagon's piece.
     */
    @Requires("source.getPiece() != null && target.getPiece() != null")
    @Ensures("target.getPiece().getAttackingPower() != old (target.getPiece().getAttackingPower())")
    public boolean attack(Hexagon source,Hexagon target){
        if(abs(source.getX()-target.getX()) > getAttackingDistance()||abs(source.getY()-target.getY()) > getAttackingDistance())
        {
            return false;
        }
        target.getPiece().stealth = target.getPiece().stealth - source.getPiece().attackingPower;
        if(target.getPiece().stealth <= 0)
            target.setPiece(null);
        return true;
    }

    /**
     * This method is used to for attacking a hexagon's piece
     * @param player This is the player to check against
     * @return boolean This returns if the player owns this piece.
     */
    public boolean isOwner(Player player)
    {
        return owner.equals(player);
    }

}
