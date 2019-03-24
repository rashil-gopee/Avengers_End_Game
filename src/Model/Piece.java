package Model;

public abstract class Piece {
    public int stealth;
    public int attackingPower;
    public int attackingDistance;
    public Hexagon position;

    public Piece(int stealth, int attackingPower, int attackingDistance) {
        this.stealth = stealth;
        this.attackingPower = attackingPower;
        this.attackingDistance = attackingDistance
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

    public void move(Hexagon hexagon) {

    }

    public void attack (Hexagon hexagon) {

    }

}
