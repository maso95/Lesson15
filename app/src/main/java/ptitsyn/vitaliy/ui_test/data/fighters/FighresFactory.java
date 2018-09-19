package ptitsyn.vitaliy.ui_test.data.fighters;

import java.util.HashMap;
import java.util.Random;

import ptitsyn.vitaliy.ui_test.data.fighters.dragonRiders.DragonRider;
import ptitsyn.vitaliy.ui_test.data.fighters.dragons.Dragon;
import ptitsyn.vitaliy.ui_test.data.fighters.knights.Knight;

/**
 * Created by vitaliyptitsyn on 9/15/18.
 * TODO: Add class explanation
 */
public class FighresFactory {

    static HashMap<FighterType, String> urlDataBase = new HashMap<>();


    static {
        urlDataBase.put(FighterType.DRAGON, "https://visualpharm.com/assets/963/Dragon-595b40b75ba036ed117d5ceb.svg");
        urlDataBase.put(FighterType.DRAGON_RIDER, "http://img09.deviantart.net/f7a3/i/2014/320/f/8/hallowen_dragon_riders_by_aeral21-d86l0os.jpg");
        urlDataBase.put(FighterType.KNIGHT, "https://cdn0.iconfinder.com/data/icons/the-middle-ages/500/Knight_knight-512.png");
    }

    static class UnknownFighterException extends RuntimeException {
    }

    public static ArenaFighter generateFighter (FighterType fighterType) {
        return generateFighter(fighterType, fighterType.name());
    }

    public static ArenaFighter generateFighter (FighterType fighterType, String name) {
        switch ( fighterType ) {
            case DRAGON:
                return new Dragon(name, generatevalue(300),
                        generatevalue(30),
                        generateProcentVlaue(), 0,
                        urlDataBase.get(fighterType));
            case KNIGHT:
                return new Knight(name, generatevalue(300),
                        generatevalue(30),
                        generateProcentVlaue(),
                        generateProcentVlaue(),
                        urlDataBase.get(fighterType)
                );
            case DRAGON_RIDER:
                return new DragonRider(name,
                        generatevalue(300),
                        generatevalue(30),
                        generateProcentVlaue(),
                        urlDataBase.get(fighterType));

        }
        throw new UnknownFighterException();
    }

    private static float generatevalue (int max) {
        Random random = new Random();
        return random.nextInt(max);

    }

    private static float generateProcentVlaue () {
        Random random = new Random();
        return (float) random.nextGaussian();

    }

}
