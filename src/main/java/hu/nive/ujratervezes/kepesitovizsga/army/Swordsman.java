package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit{

    private boolean shield = true;

    public Swordsman(boolean armour) {
        hitPoints = 100;
        damage = 10;
        this.armour = armour;
    }

    @Override
    public void sufferDamage(int damage) {
        if (!shield) {
            super.sufferDamage(damage);
        } else {
            shield = false;
        }
    }
}
