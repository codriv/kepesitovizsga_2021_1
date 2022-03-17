package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Army {

    private Set<MilitaryUnit> army = new HashSet<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        army.add(militaryUnit);
    }

    public void damageAll(int damage) {
        army.forEach(unit -> unit.sufferDamage(damage));
        List<MilitaryUnit> unfitForFights = army.stream().filter(unit -> unit.getHitPoints() < 25).collect(Collectors.toList());
        army.removeAll(unfitForFights);
    }

    public int getArmyDamage() {
        return army.stream().mapToInt(MilitaryUnit::doDamage).sum();
    }

    public int getArmySize() {
        return army.size();
    }


}
