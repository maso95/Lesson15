package ptitsyn.vitaliy.ui_test.data.fighters.magicians;


import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.fighters.Elements;

public class Mage extends ArenaFighter implements Elements {
    int element;

    public Mage (String name, float health, float damage, float armor, int element) {
        super(name, health, damage, armor,null);
        this.element = element;
    }

    @Override
    public float attack (ArenaFighter fighters) {
        if( fighters instanceof Elements ) {
            if( isElementsEquals(((Elements) fighters).getElements()) ) {
                return 0;
            }
        }
        return fighters.damaged(damage);
    }

    @Override
    public int getElements () {
        return element;
    }
}
