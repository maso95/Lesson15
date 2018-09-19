package ptitsyn.vitaliy.ui_test.bl.arenas;


import android.widget.TextView;

import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.healers.Healer;

public class DuelArena extends BattleArena {
    TextView winner;

    TextView dmgDone;
    TextView hpLeft;

    protected ArenaFighter participant1;
    protected ArenaFighter participant2;
    private int roundCountMax;


    public DuelArena (Healer healer, ArenaFighter participant1, ArenaFighter participant2, int roundCountMax) {
        super(healer);
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.roundCountMax = roundCountMax;
    }

    @Override
    public void startBattle () {
        setStartRound(true);
        int currentRound = 0;
        while (currentRound < roundCountMax && isFightContinue(participant1, participant2)) {
            confrontation(participant1, participant2);
            currentRound++;
        }
    }

    @Override
    public ArenaFighter printWinner () {
        if( isStartRound() ) {
            ArenaFighter winners = calculationOfWinner(participant1, participant2);
            if( winners != null ) {
                return winners;
            }
    }
    return participant2;
}
}
