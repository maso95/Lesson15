package ptitsyn.vitaliy.ui_test.data.fighters.dragons;


import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.fighters.Elements;
import ptitsyn.vitaliy.ui_test.data.fighters.dragonRiders.DragonRider;

public class Dragon extends ArenaFighter implements Elements {
    private int params;

    public Dragon(String name, float health, float damage, float armor, int params,String url) {
        super(name, health, damage, armor,url);
        this.params = params;
    }

    private float attackDragon(Dragon dragon) {
        float damageTaken = 0f;
        int degreeCritDamage = 3;
        float superDamage = calculationChanceCritDamage(this.damage, degreeCritDamage);
        if ((params & FIRE) == FIRE && (dragon.params & WATER) == WATER) {
            damageTaken += superDamage * 2;
        } else damageTaken += superDamage;
        if ((params & WATER) == WATER && (dragon.params & EARTH) == EARTH) {
            damageTaken += superDamage * 2;
        } else damageTaken += superDamage;
        if ((params & EARTH) == EARTH && (dragon.params & WIND) == WIND) {
            damageTaken += superDamage * 2;
        } else damageTaken += superDamage;
        if ((params & WIND) == WIND && (dragon.params & FIRE) == FIRE) {
            damageTaken += superDamage * 2;
        } else damageTaken += superDamage;

        return dragon.damaged(damageTaken);
    }

    private float calculationChanceCritDamage(float damage, int degreeCritDamage) {
        int randomNum = (int) (Math.random() * 10) + 1;
        if (randomNum == 10) {
            return (float) Math.pow(damage, degreeCritDamage);
        }
        return damage;
    }

    @Override
    public float attack(ArenaFighter fighters) {
        if (fighters instanceof Dragon) {
            return attackDragon((Dragon) fighters);
        } else if (!(fighters instanceof DragonRider)) {
            return fighters.damaged(this.damage);
        } else
            return 0;
    }

    @Override
    public int getElements() {
        return params;
    }

}
