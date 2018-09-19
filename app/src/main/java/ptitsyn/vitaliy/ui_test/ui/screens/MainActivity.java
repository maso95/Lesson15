package ptitsyn.vitaliy.ui_test.ui.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ptitsyn.vitaliy.ui_test.R;
import ptitsyn.vitaliy.ui_test.bl.arenas.DuelArena;
import ptitsyn.vitaliy.ui_test.data.fighters.ArenaFighter;
import ptitsyn.vitaliy.ui_test.data.fighters.FighresFactory;
import ptitsyn.vitaliy.ui_test.data.fighters.FighterType;
import ptitsyn.vitaliy.ui_test.data.healers.Healer;

public class MainActivity extends AppCompatActivity {

    private static final String CURRENT_FITER_KEY = "CURRENT_FITER_KEY";


    ImageView profileImage;
    ImageView enemyImage;

    TextView profileName;
    TextView profileDescription;
    TextView enemyName;

    TextView currentHp;
    TextView currentArrmor;
    TextView currentDamage;

    TextView enemyHp;
    TextView enemyArrmor;
    TextView enemyDamage;

    TextView currentWinner;
    TextView hpLeft;
    TextView dmgDone;

    TextView startnewChange;


    ArenaFighter currentFighter;
    ArenaFighter enemyFighter;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initFighter(savedInstanceState);
        setDataOnUi();

    }

    private void setDataOnUi () {
        profileName.setText(currentFighter.getName());
        profileDescription.setText(currentFighter.getDescription());


        Glide.with(this)
                .load(currentFighter.getImageUrl())
                .into(profileImage);

        currentHp.setText(String.valueOf(currentFighter.getHealth()));
        currentDamage.setText(String.valueOf(currentFighter.getDamage()));
        currentArrmor.setText(String.valueOf(currentFighter.getArmor()));


    }

    private void initEnemy(){
            enemyFighter = FighresFactory.generateFighter(FighterType.KNIGHT, "Aragorn");
            }

    private void initFighter (Bundle savedInstanceState) {
        if( savedInstanceState == null ) {
            currentFighter = FighresFactory.generateFighter(FighterType.DRAGON_RIDER, "Ikking");
        } else {
            onSaveInstanceState(savedInstanceState);
        }
    }

    private void initViews () {
        profileImage = findViewById(R.id.fighter_icon);

        profileName = findViewById(R.id.fighter_name);
        profileDescription = findViewById(R.id.fighter_description);

        currentHp = findViewById(R.id.value_hp);
        currentArrmor = findViewById(R.id.value_armor);
        currentDamage = findViewById(R.id.value_damage);

        currentWinner = findViewById(R.id.a_winner);
        hpLeft = findViewById(R.id.hp_left);
        dmgDone = findViewById(R.id.dmg_done);

        startnewChange = findViewById(R.id.btn_start_new_chalange);
        startnewChange.setOnClickListener(this::startnewFiht);
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_FITER_KEY, currentFighter);
    }

    private void startnewFiht (View view) {
        initEnemy();
       DuelArena battle = new DuelArena (new Healer("Whitemane",40),currentFighter,enemyFighter,3);
        addFiregResultOLaoyut(battle.printWinner());
        //TOOD write fight logic
    }

    private void addFiregResultOLaoyut (ArenaFighter winner) {

        enemyImage = findViewById(R.id.enemy_icon);
        enemyName = findViewById(R.id.enemy_name);
        enemyHp = findViewById(R.id.enemy_hp);
        enemyArrmor = findViewById(R.id.enemy_armor);
        enemyDamage = findViewById(R.id.enemy_damage);

        currentWinner.setText(winner.getName());
        hpLeft.setText((int)(winner.getHealth()));

        findViewById(R.id.vs_wind).setVisibility(View.VISIBLE);
        // TODO  inflate layout from R.
        // SetUpd data to view
        // add view to battle_history
    }


}
