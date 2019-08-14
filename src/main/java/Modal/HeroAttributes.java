package Modal;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.ThreadLocalRandom;



@Getter
@Setter

public abstract class HeroAttributes {

    @NotNull
    @Size(min= 2, max = 20, message = "charecter name should be between 2 and 16")
    protected String name;

    @NotNull
    protected int attack;

    @NotNull
    protected int defense;

    @NotNull
    protected int hitPoints;


    public HeroAttributes(String name, int attack, int defense, int hitPoints) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }

    private void attack(HeroAttributes opponent) {
        if (this.attack > opponent.defense) {
            opponent.setHitPoints(opponent.getHitPoints() - (this.attack - opponent.defense));
        } else if (ThreadLocalRandom.current().nextInt(0, 10) <= 2) {
            opponent.setHitPoints(opponent.getHitPoints() - this.attack);
        }
    }

    public boolean fight(HeroAttributes opponent) {
        while (opponent.getHitPoints() > 0 && this.getHitPoints() > 0) {
            this.attack(opponent);
            opponent.attack(this);
        }
        return this.getHitPoints() > 0;
    }

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }*/
}
