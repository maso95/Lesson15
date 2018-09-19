package ptitsyn.vitaliy.ui_test.data.fighters.knights;


import ptitsyn.vitaliy.ui_test.data.fighters.PostAttackAction;

 public class HollyKnight extends Knight implements PostAttackAction {
    private float recovery;

    public HollyKnight(String name, float health, float damage, float armor, float shield, float recovery) {
        super(name, health, damage, armor, shield,null);
        this.recovery = recovery;
    }

    private void recovery() {
        if (this.isAlfie()) {
            this.heal(recovery);
            System.out.println(this.getName() + " recovery " + recovery);
        }
    }

    @Override
    public void postAttackAction(float damageTaken, float damageGotten) {
        recovery();
    }
}