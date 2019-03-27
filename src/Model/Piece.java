package Model;

public abstract class Piece {
    private int stealth;
    private int attackingPower;
    private int attackingDistance;
    private Player owner;

    public Piece(int stealth, int attackingPower, int attackingDistance, Player owner) {
        this.stealth = stealth;
        this.attackingPower = attackingPower;
        this.attackingDistance = attackingDistance;
        this.owner = owner;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getAttackingPower() {
        return attackingPower;
    }

    public void setAttackingPower(int attackingPower) {
        this.attackingPower = attackingPower;
    }

    public int getAttackingDistance() {
        return attackingDistance;
    }

    public void setAttackingDistance(int attackingDistance) {
        this.attackingDistance = attackingDistance;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


}
