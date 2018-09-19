package ptitsyn.vitaliy.ui_test.data.fighters;

public enum FighterType {
    DRAGON(1), DRAGON_RIDER(2), KNIGHT(3);

    FighterType (int type) {
        this.type = type;
    }

    int type;
}