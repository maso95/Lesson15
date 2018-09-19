package ptitsyn.vitaliy.ui_test.data.fighters.knights;

import ptitsyn.vitaliy.ui_test.data.fighters.PostAttackAction;

public class BlackKinght extends Knight implements PostAttackAction {
    public BlackKinght(String name, float health, float damage, float armor, float shield) {
        super(name, health, damage, armor, shield,null);
    }

    private void recovery(float damageTaken) {
        if (this.isAlfie()) {
            float recovery = damageTaken / 2;
            this.heal(recovery);
            System.out.println(this.getName() + " recovery " + recovery);
        }
    }


    @Override
    public void postAttackAction(float damageGiven, float damageGotten) {
        recovery(damageGiven);
    }


}
