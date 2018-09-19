package ptitsyn.vitaliy.ui_test.data.fighters.dragonRiders;


import android.os.Parcel;

import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.fighters.dragons.Dragon;

public class DragonRider extends ArenaFighter {
    private Dragon ridingDragon;
    private float healthDragon;

    public DragonRider (String name, float health, float damage, float armor, String url) {
        super(name, health, damage, armor, url);
    }

    @Override
    public float attack (ArenaFighter var1) {
        if( var1 instanceof Dragon ) {
            attackDragon((Dragon) var1);
            return 0;
        } else {
            return var1.damaged(this.damage);
        }
    }

    private void attackDragon (Dragon dragon) {
        this.ridingDragon = dragon;
        healthDragon = dragon.getHealth();
        dragon.setHealth(0);
    }

    @Override
    public void writeToParcel (Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(ridingDragon,flags);
    }
}
