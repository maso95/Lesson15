package ptitsyn.vitaliy.ui_test.bl.arenas;


import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.fighters.PostAttackAction;
import ptitsyn.vitaliy.ui_test.data.healers.Healer;

public abstract class BattleArena {
    private boolean startRound = false;
    protected Healer healer;
    protected GodHand godHand;

    public BattleArena() {
    }

    public BattleArena(Healer healer) {
        this.healer = healer;
    }

    public abstract void startBattle();

    public void setGodHand(GodHand godHand) {
        this.godHand = godHand;
    }

    public abstract ArenaFighter printWinner();

    public ArenaFighter calculationOfWinner(ArenaFighter participant1, ArenaFighter participant2) {
        if (participant1 != null && participant2 != null) {
            if (participant1.isAlfie() && participant2.isAlfie()) {
                return (participant1.getHealth() > participant2.getHealth()) ? participant1 : participant2;
            } else if (participant1.isAlfie()) {
                return participant1;
            } else if (participant2.isAlfie()) {
                return participant2;
            }
        }
        return null;
    }

    public boolean isStartRound() {
        return startRound;
    }

    protected void setStartRound(boolean startRound) {
        this.startRound = startRound;
    }

    protected void confrontation(ArenaFighter participant1, ArenaFighter participant2) {
        if (isFightContinue(participant1, participant2)) {
            float dam1 = participant1.attack(participant2);
            float dam2 = participant2.attack(participant1);
            if (participant1 instanceof PostAttackAction ) {
                ((PostAttackAction) participant1).postAttackAction(dam1, dam2);
            }

            if (participant2 instanceof PostAttackAction) {
                ((PostAttackAction) participant2).postAttackAction(dam2, dam1);
            }

            if (healer != null) {
                healer.heal(dropTheCoin() ? participant1 : participant2);
            }

            if (godHand != null) {
                godHand.godHand(participant1, participant2);
            }
        }
    }

    protected boolean dropTheCoin() {
        int randomNum = (int) (Math.random() * 100);
        return (randomNum % 2) == 0;
    }

    protected boolean isFightContinue(ArenaFighter participant1, ArenaFighter participant2) {
        if (participant1 != null && participant2 != null) {
            return participant1.isAlfie() && participant2.isAlfie();
        } else {
            return false;
        }
    }

    public interface GodHand {
        boolean godHand (ArenaFighter participant1, ArenaFighter participant2);
    }
}
