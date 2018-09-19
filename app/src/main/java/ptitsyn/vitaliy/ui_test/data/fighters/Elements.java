package ptitsyn.vitaliy.ui_test.data.fighters;

public interface Elements {
    int FIRE = 2;
    int WATER = 4;
    int EARTH = 8;
    int WIND = 16;

    int getElements ();

    default boolean isElementsEquals (int elements) {
        return (getElements() & elements) == getElements();
    }
}
