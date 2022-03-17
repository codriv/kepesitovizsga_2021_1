package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit{

    int numberOfAttack;

    public HeavyCavalry() {
        hitPoints = 150;
        damage = 20;
        armour = true;
    }

    @Override
    public int doDamage() {
        if (numberOfAttack == 0) {
            numberOfAttack++;
            return damage * 3;
        } else {
            return damage;
        }
    }
}
