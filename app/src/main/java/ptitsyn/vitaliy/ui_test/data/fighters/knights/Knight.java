package ptitsyn.vitaliy.ui_test.data.fighters.knights;


import android.os.Parcel;

import java.util.Random;

import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;

public class Knight extends ArenaFighter {
    protected float shield;

    public Knight (String name, float health, float damage, float armor, float shield, String imageUrl) {
        super(name, health, damage, armor, imageUrl);
        this.shield = shield;
    }

    public float attack (ArenaFighter arenaFighter) {
        return arenaFighter.damaged(this.damage);
    }

    public float damaged (float damageTaken) {
        Random random = new Random();
        if( random.nextGaussian() > (double) this.shield ) {
            return super.damaged(damageTaken);
        } else {
            System.out.println(this.name + " blocked");
        }
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeFloat(shield);
    }

    @Override
    protected int getType() {
        return 0;
    }
}
