package ptitsyn.vitaliy.ui_test.data.fighters;


import android.os.Parcel;
import android.os.Parcelable;

public abstract class ArenaFighter implements Parcelable {
    protected String name;
    protected String imageUrl;
    protected float health;
    protected float damage;
    protected float armor;
    protected float maxHealth;

    public ArenaFighter (String name,
                         float health,
                         float damage,
                         float armor,
                         String imageUrl
    ) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.maxHealth = health;
    }

    public boolean isAlfie () {
        return health > 0;
    }

    public String getName () {
        return this.name;
    }

    public void heal (float health) {
        float newHeal = this.health + health;
        this.health = Math.min(newHeal, this.maxHealth);
    }

    public abstract float attack (ArenaFighter var1);

    public float damaged (float damageTaken) {
        float resist = (damageTaken * armor);
        float gotDamage = damageTaken - resist;
        health -= gotDamage;
        System.out.println(name + " got damage " + gotDamage + " resisted "
                + resist + " health left " + health);
        return gotDamage;
    }


    public String getImageUrl () {
        return imageUrl;
    }

    public float getMaxHealth () {
        return maxHealth;
    }

    public float getHealth () {
        return health;
    }

    public float getDamage () {
        return damage;
    }

    public float getArmor () {
        return armor;
    }

    public void setHealth (float health) {
        this.health = health;
    }

    public String getDescription () {
        return "Descrtiption";
    }


    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest, int flags) {
        dest.writeInt(getType());
        dest.writeString(this.name);
        dest.writeString(this.imageUrl);
        dest.writeFloat(this.health);
        dest.writeFloat(this.damage);
        dest.writeFloat(this.armor);
        dest.writeFloat(this.maxHealth);
    }

    /**
     * TODO return unicFalue for type
     *
     * @return
     */
    protected abstract int getType ();

    protected ArenaFighter (Parcel in) {
        this.name = in.readString();
        this.imageUrl = in.readString();
        this.health = in.readFloat();
        this.damage = in.readFloat();
        this.armor = in.readFloat();
        this.maxHealth = in.readFloat();
    }

    public static final Creator<ArenaFighter> CREATOR = new Creator<ArenaFighter>() {
        public ArenaFighter createFromParcel (Parcel source) {
            int type = source.readInt();
            //swtich on type
//            return new ArenaFighter(source);
            //TODO write deserilization
            throw new RuntimeException(); //todo remove
        }

        public ArenaFighter[] newArray (int size) {
            return new ArenaFighter[size];
        }
    };
}
