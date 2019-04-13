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

    public abstract boolean canMove(Hexagon source,Hexagon target);

    public void suffer(int stealth) {
        this.stealth = this.stealth - stealth;
    }

    public boolean isOwner(Player player)
    {
        return owner.equals(player);
    }

}
