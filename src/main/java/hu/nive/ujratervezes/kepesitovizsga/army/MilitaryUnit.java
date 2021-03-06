package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    protected int hitPoints;
    protected int damage;
    protected boolean armour;

    public MilitaryUnit() {
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public boolean hasArmour() {
        return armour;
    }

    public int doDamage() {
        return this.damage;
    }

    public void sufferDamage(int damage) {
        hitPoints -= hasArmour() ? damage / 2 : damage;
    }
}
