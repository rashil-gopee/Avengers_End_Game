package Model;

import Model.Composite.PieceComposite;
import Model.Strategy.AttackStrategy;
import Model.Composite.CommandComposite;

import java.io.Serializable;

import static java.lang.Math.abs;

public abstract class Piece extends PieceComposite implements Serializable {
    private boolean isSpecialEffectUsed;
    private int stealth;
//    private int attackingPower;
    private int attackingDistance;
    private String image;
    private Player owner;

    private AttackStrategy attackStrategy;

    public Piece(int stealth, int attackingDistance, String image, Player owner, AttackStrategy attackStrategy) {
        this.stealth = stealth;
//        this.attackingPower = attackingPower;
        this.attackingDistance = attackingDistance;
        this.image = image;
        this.owner = owner;
        isSpecialEffectUsed = false;
        this.attackStrategy = attackStrategy;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getStealth() {
        return stealth;
    }

//    public int getAttackingPower() {
//        return attackingPower;
//    }
//
    public int getAttackingDistance() {
        return attackingDistance;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public boolean isSpecialEffectUsed() {
        return isSpecialEffectUsed;
    }

    public void setSpecialEffectUsed(boolean specialEffectUsed) {
        isSpecialEffectUsed = specialEffectUsed;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public abstract boolean move(Hexagon source,Hexagon target);


    /**
     * This method is used to for attacking a hexagon's piece
     * @param player This is the player to check against
     * @return boolean This returns if the player owns this piece.
     */
    public boolean isOwner(Player player)
    {
        return owner.equals(player);
    }

    public void specialEffect(Hexagon hexagon, CommandComposite commands) {
        this.isSpecialEffectUsed = true;

        CommandComposite commandComposite = new CommandComposite();
        commandComposite.add(new CommandComposite());
        System.out.println("Special Effect");
    }

    @Override
    public void suffer(int stealth) {
        this.stealth = this.stealth - stealth;
    }

    @Override
    public void heal(int stealth) {
        this.stealth = this.stealth + stealth;
    }

}
