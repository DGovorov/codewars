package fundamentals;

/**
 * Created by Dim on 01.09.2016.
 */
public class FighterKata {
    Fighter attacker;
    Fighter victim;

    public FighterKata (Fighter fighter1, Fighter fighter2, String firstAttacker) {
        this.attacker = fighter1;
        this.victim = fighter2;

        if (fighter1.name.equals(firstAttacker)){
            switchFighters();
        }
    }

    public String declareWinner() {
        boolean dead = false;

        while (!dead) {
            switchFighters();
            dead = hit();
            String output = String.format("%1$s attacks %2$s; %2$s now has %3$d health.", attacker.name, victim.name, victim.health);
            System.out.println(output);
        }

        System.out.println(victim.name + " is dead.");
        return attacker.name;
    }

    private void switchFighters() {
        Fighter temp = attacker;
        attacker = victim;
        victim = temp;
    }

    public boolean hit() {
        victim.health -= attacker.damagePerAttack;
        return victim.health <= 0;
    }

}