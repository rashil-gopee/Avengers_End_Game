package Model;

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
    public abstract boolean move(Hexagon source,Hexagon target);

    public  boolean attack(Hexagon source,Hexagon target){
        if(abs(source.getX()-target.getX())>getAttackingDistance()||abs(source.getY()-target.getY())>getAttackingDistance())
        {
            return false;
        }
        int stealthLeft=target.getPiece().damage(attackingPower);
        if(stealthLeft==0)
            target.setPiece(null);
        return true;
    }

    public boolean isOwner(Player player)
    {
        if(owner.equals(player))
            return true;
        return false;
    }
    public int damage(int attack)
    {
        if(stealth>attack)
            stealth=stealth-attack;
        else
            stealth=0;
        return stealth;
    }
}
