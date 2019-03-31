package Model;

import java.awt.*;

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
    public abstract void move(Hexagon source,Hexagon target);

    public abstract void attack(Hexagon hexagon);
}
