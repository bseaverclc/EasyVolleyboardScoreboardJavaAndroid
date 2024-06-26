package com.example.easyvolleyboardscoreboardjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private RadioButton set1,set2,set3,set4,set5;

private Button redScoreButton;
private Button redAceButton;
private Button redBlockButton;
private Button redKillButton;
private Button redAtkButton;
private Button redDigButton;
private Button redOppAtkErrButton;
private Button redOppServeErrButton;
private Button redOppOtherErrButton;
private Button redOneButton;
private Button redTwoButton;
private Button redThreeButton;
private TextView redHitPctView;
private TextView redPassAvgView;
private TextView redEarnedPctView;

    private Button blueScoreButton;
    private Button blueAceButton;
    private Button blueBlockButton;
    private Button blueKillButton;
    private Button blueAtkButton;
    private Button blueDigButton;
    private Button blueOppAtkErrButton;
    private Button blueOppServeErrButton;
    private Button blueOppOtherErrButton;
    private Button blueOneButton;
    private Button blueTwoButton;
    private Button blueThreeButton;
    private TextView blueHitPctView;
    private TextView bluePassAvgView;
    private TextView blueEarnedPctView;

private int rkill = 0;
private Game game;
private ArrayList<String> teams = new ArrayList<String>();

private ASet set;
private int setNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams.add("A");
        teams.add("B");
        createButtons();
        createGame();
    }

    private void createButtons(){
        set1 = findViewById(R.id.set1);
        set1.setOnClickListener(this);
        set2 = findViewById(R.id.set2);
        set2.setOnClickListener(this);
       set3 = findViewById(R.id.set3);
        set3.setOnClickListener(this);
       set4 = findViewById(R.id.set4);
        set4.setOnClickListener(this);
        set5 = findViewById(R.id.set5);
        set5.setOnClickListener(this);


        redHitPctView = (TextView)findViewById(R.id.redHitPct);
        redPassAvgView = (TextView)findViewById(R.id.redPassAvg);
        redEarnedPctView = (TextView)findViewById(R.id.redEarnedPct);
        blueHitPctView = (TextView)findViewById(R.id.blueHitPct);
        bluePassAvgView = (TextView)findViewById(R.id.bluePassAvg);
        blueEarnedPctView = (TextView)findViewById(R.id.blueEarnedPct);


        redScoreButton = (Button)findViewById(R.id.redScore);
        redScoreButton.setOnClickListener(this);
        redAceButton = (Button)findViewById(R.id.redAce);
        redAceButton.setOnClickListener(this);
        redBlockButton = (Button)findViewById(R.id.redBlock);
        redBlockButton.setOnClickListener(this);
        redKillButton = (Button)findViewById(R.id.redKill);
        redKillButton.setOnClickListener(this);
        redAtkButton = (Button)findViewById(R.id.redAttack);
        redAtkButton.setOnClickListener(this);
        redDigButton = (Button)findViewById(R.id.redDig);
        redDigButton.setOnClickListener(this);
        redOppAtkErrButton = (Button)findViewById(R.id.redOppAttackErr);
        redOppAtkErrButton.setOnClickListener(this);
        redOppServeErrButton = (Button)findViewById(R.id.redOppServeErr);
        redOppServeErrButton.setOnClickListener(this);
        redOppOtherErrButton = (Button)findViewById(R.id.redOppOtherErr);
        redOppOtherErrButton.setOnClickListener(this);
        redOneButton = (Button)findViewById(R.id.redOne);
        redOneButton.setOnClickListener(this);
        redTwoButton = (Button)findViewById(R.id.redTwo);
        redTwoButton.setOnClickListener(this);
        redThreeButton = (Button)findViewById(R.id.redThree);
        redThreeButton.setOnClickListener(this);

        blueScoreButton = (Button)findViewById(R.id.blueScore);
        blueScoreButton.setOnClickListener(this);
        blueAceButton = (Button)findViewById(R.id.blueAce);
        blueAceButton.setOnClickListener(this);
        blueBlockButton = (Button)findViewById(R.id.blueBlock);
        blueBlockButton.setOnClickListener(this);
        blueKillButton = (Button)findViewById(R.id.blueKill);
        blueKillButton.setOnClickListener(this);
        blueAtkButton = (Button)findViewById(R.id.blueAttack);
        blueAtkButton.setOnClickListener(this);
        blueDigButton = (Button)findViewById(R.id.blueDig);
        blueDigButton.setOnClickListener(this);
        blueOppAtkErrButton = (Button)findViewById(R.id.blueOppAttackErr);
        blueOppAtkErrButton.setOnClickListener(this);
        blueOppServeErrButton = (Button)findViewById(R.id.blueOppServeErr);
        blueOppServeErrButton.setOnClickListener(this);
        blueOppOtherErrButton = (Button)findViewById(R.id.blueOppOtherErr);
        blueOppOtherErrButton.setOnClickListener(this);
        blueOneButton = (Button)findViewById(R.id.blueOne);
        blueOneButton.setOnClickListener(this);
        blueTwoButton = (Button)findViewById(R.id.blueTwo);
        blueTwoButton.setOnClickListener(this);
        blueThreeButton = (Button)findViewById(R.id.blueThree);
        blueThreeButton.setOnClickListener(this);

    }

    public void createGame(){
        System.out.println("new Game being created");
        game = new Game(teams,new Date(), false);
        game.getSets().add(new ASet());
        game.getSets().add(new ASet());
        game.getSets().add(new ASet());
        game.getSets().add(new ASet());
        game.getSets().add(new ASet());
        set = game.getSets().get(0);
        setNum = 1;
//        self.setSegmentedControlOutlet.selectedSegmentIndex = 0
//        AppData.canEdit = true
//        AppData.selectedGame = game
//        redTextFieldOutlet.isEnabled = true
//        blueTextFieldOutlet.isEnabled = true
//        self.updateScreen()
    }

    public void updateScreen(){
        redScoreButton.setText("" + set.getRedStats().get("redScore"));
        redAceButton.setText("Ace\n"+set.getRedStats().get("Ace"));
        redBlockButton.setText("Block\n"+set.getRedStats().get("Block"));
        redKillButton.setText("Kill\n"+set.getRedStats().get("Kill"));
        redAtkButton.setText("Atk\n" + set.getRedAttack());
        redDigButton.setText("Dig\n" + set.getRedDigs());
        redOppAtkErrButton.setText("Opp\nAttack\nErr\n"+set.getRedStats().get("Opponent Attack Err"));
        redOppServeErrButton.setText("Opp\nServe\nErr\n"+set.getRedStats().get("Opponent Serve Err"));
        redOppOtherErrButton.setText("Opp\nOther\nErr\n"+set.getRedStats().get("Opponent Err"));
        redOneButton.setText("1SR\n" + set.getRedOne());
        redTwoButton.setText("2SR\n" + set.getRedTwo());
        redThreeButton.setText("3SR\n" + set.getRedThree());

        blueScoreButton.setText("" + set.getBlueStats().get("blueScore"));
        blueAceButton.setText("Ace\n"+set.getBlueStats().get("Ace"));
        blueBlockButton.setText("Block\n"+set.getBlueStats().get("Block"));
        blueKillButton.setText("Kill\n"+set.getBlueStats().get("Kill"));
        blueAtkButton.setText("Atk\n" + set.getBlueAttack());
        blueDigButton.setText("Dig\n" + set.getBlueDigs());
        blueOppAtkErrButton.setText("Opp\nAttack\nErr\n"+set.getBlueStats().get("Opponent Attack Err"));
        blueOppServeErrButton.setText("Opp\nServe\nErr\n"+set.getBlueStats().get("Opponent Serve Err"));
        blueOppOtherErrButton.setText("Opp\nOther\nErr\n"+set.getBlueStats().get("Opponent Err"));
        blueOneButton.setText("1SR\n" + set.getBlueOne());
        blueTwoButton.setText("2SR\n" + set.getBlueTwo());
        blueThreeButton.setText("3SR\n" + set.getBlueThree());

        updatePercents();
    }

    public void updatePercents(){
// red hit % calculation
        if (set.getRedAttack() != 0) {
            double redPct = (set.getRedStats().get("Kill") - set.getBlueStats().get("Opponent Attack Err")) / (double) set.getRedAttack();

            redHitPctView.setText("Hit % " + String.format("%.3f", redPct));
        }
        else{
            redHitPctView.setText("Hit % 0.000");
        }
// red pass average calculation
        int redTotal = set.getRedOne() + 2*set.getRedTwo() + 3*set.getRedThree();
        int redNum = set.getRedOne() + set.getRedTwo() + set.getRedThree() + set.getBlueStats().get("Ace");
        if (redNum !=0){
            double redPassAvg = redTotal/(double)redNum;
            redPassAvgView.setText("Pass Avg " + String.format("%.2f", redPassAvg));
        }
        else{
            redPassAvgView.setText("Pass Avg: N/A");
        }
// red earned % calculation
        int redGood = set.getRedStats().get("Ace")  + set.getRedStats().get("Block")  + set.getRedStats().get("Kill");
        if (set.getRedStats().get("redScore") != 0){
            int redEarned = (int)(Math.round(redGood/(double)set.getRedStats().get("redScore")*100));
            redEarnedPctView.setText("Earned " + redEarned + "%");
        }

// blue calculations
// blue hit % calculation
        if (set.getBlueAttack() != 0) {
            double bluePct = (set.getBlueStats().get("Kill") - set.getRedStats().get("Opponent Attack Err")) / (double) set.getBlueAttack();

            blueHitPctView.setText("Hit % " + String.format("%.3f", bluePct));
        }
        else{
            blueHitPctView.setText("Hit % 0.000");
        }
 //blue pass average calculation
        int blueTotal = set.getBlueOne() + 2*set.getBlueTwo() + 3*set.getBlueThree();
        int blueNum = set.getBlueOne() + set.getBlueTwo() + set.getBlueThree() + set.getBlueStats().get("Ace");
        if (blueNum !=0){
            double bluePassAvg = blueTotal/(double)blueNum;
            bluePassAvgView.setText("Pass Avg " + String.format("%.2f", bluePassAvg));
        }
        else{
            bluePassAvgView.setText("Pass Avg: N/A");
        }
// blue earned % calculation
        int blueGood = set.getBlueStats().get("Ace")  + set.getBlueStats().get("Block")  + set.getBlueStats().get("Kill");
        if (set.getBlueStats().get("blueScore") != 0){
            int blueEarned = (int)(Math.round(blueGood/(double)set.getBlueStats().get("blueScore")*100));
            blueEarnedPctView.setText("Earned " + blueEarned + "%");
        }



    }

    public void redScoreAction(View view){
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void redAceAction(View view){
        set.getRedStats().put("Ace", set.getRedStats().get("Ace") + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Ace", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }

    public void redBlockAction(View view){
        // System.out.println("redkill");
        set.getRedStats().put("Block", set.getRedStats().get("Block") + 1);
        set.setBlueAttack(set.getBlueAttack() + 1);
        set.getRedStats().put("Opponent Attack Err", set.getRedStats().get("Opponent Attack Err") + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Block", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void redKillAction(View view){
       // System.out.println("redkill");
        set.getRedStats().put("Kill", set.getRedStats().get("Kill") + 1);
        set.setRedAttack(set.getRedAttack() + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Kill", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());

    }

    public void redOppAttackErrAction(View view){
        // System.out.println("redkill");
        set.getRedStats().put("Opponent Attack Err", set.getRedStats().get("Opponent Attack Err") + 1);
        set.setBlueAttack(set.getBlueAttack() + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Opp Atk Err", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }

    public void redOppServeErrAction(View view){
        // System.out.println("redkill");
        set.getRedStats().put("Opponent Serve Err", set.getRedStats().get("Opponent Serve Err") + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Opp Sv Err", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void redOppOtherErrAction(View view){
        // System.out.println("redkill");
        set.getRedStats().put("Opponent Err", set.getRedStats().get("Opponent Err") + 1);
        set.getRedStats().put("redScore", set.getRedStats().get("redScore") + 1);
        Point point = new Point(set.getServe(), set.getRedRotation(), set.getBlueRotation(), "red", "Opp Err", set.getRedStats().get("redScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void redAtkAction(View view){
        set.setRedAttack(set.getRedAttack() + 1);
    }
    public void redDigAction(View view){
        set.setRedDigs(set.getRedDigs() + 1);
    }

    public void redOneAction(View view){
        set.setRedOne(set.getRedOne() + 1);
    }
    public void redTwoAction(View view){
        set.setRedTwo(set.getRedTwo() + 1);
    }
    public void redThreeAction(View view){
        set.setRedThree(set.getRedThree() + 1);
    }

// Blue Actions
    public void blueScoreAction(View view){
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void blueAceAction(View view){
        set.getBlueStats().put("Ace", set.getBlueStats().get("Ace") + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Ace", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }

    public void blueBlockAction(View view){
        // System.out.println("bluekill");
        set.getBlueStats().put("Block", set.getBlueStats().get("Block") + 1);
        set.setRedAttack(set.getRedAttack() + 1);
        set.getBlueStats().put("Opponent Attack Err", set.getBlueStats().get("Opponent Attack Err") + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Block", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void blueKillAction(View view){
        // System.out.println("bluekill");
        set.getBlueStats().put("Kill", set.getBlueStats().get("Kill") + 1);
        set.setBlueAttack(set.getBlueAttack() + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Kill", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());

    }

    public void blueOppAttackErrAction(View view){
        // System.out.println("bluekill");
        set.getBlueStats().put("Opponent Attack Err", set.getBlueStats().get("Opponent Attack Err") + 1);
        set.setRedAttack(set.getRedAttack() + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Opp Atk Err", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }

    public void blueOppServeErrAction(View view){
        // System.out.println("bluekill");
        set.getBlueStats().put("Opponent Serve Err", set.getBlueStats().get("Opponent Serve Err") + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Opp Sv Err", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void blueOppOtherErrAction(View view){
        // System.out.println("bluekill");
        set.getBlueStats().put("Opponent Err", set.getBlueStats().get("Opponent Err") + 1);
        set.getBlueStats().put("blueScore", set.getBlueStats().get("blueScore") + 1);
        Point point = new Point(set.getServe(), set.getBlueRotation(), set.getBlueRotation(), "blue", "Opp Err", set.getBlueStats().get("blueScore") + "-" + set.getBlueStats().get("blueScore"));
        set.addPoint(point, game.getUid());
    }
    public void blueAtkAction(View view){
        set.setBlueAttack(set.getBlueAttack() + 1);
    }
    public void blueDigAction(View view){
        set.setBlueDigs(set.getBlueDigs() + 1);
    }

    public void blueOneAction(View view){
        set.setBlueOne(set.getBlueOne() + 1);
    }
    public void blueTwoAction(View view){
        set.setBlueTwo(set.getBlueTwo() + 1);
    }
    public void blueThreeAction(View view){
        set.setBlueThree(set.getBlueThree() + 1);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();

            if(id == R.id.set1 || id == R.id.set2 || id == R.id.set3 || id == R.id.set4 || id == R.id.set5) {
                System.out.println("set pressed");
                set1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_off));
                set2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_off));
                set3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_off));
                set4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_off));
                set5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_off));
                if (id == R.id.set1){
                    set1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_on));
                    set = game.getSets().get(0);
                    setNum = 1;
                }
                if (id == R.id.set2){
                    set2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_on));
                    set = game.getSets().get(1);
                    setNum = 2;
                }
                if (id == R.id.set3){
                    set3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_on));
                    set = game.getSets().get(2);
                    setNum = 3;
                }
                if (id == R.id.set4){
                    set4.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_on));
                    set = game.getSets().get(3);
                    setNum = 4;

                }
                if (id == R.id.set5){
                    set5.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.radio_on));
                    set = game.getSets().get(4);
                    setNum = 5;

                }
            }



        if(id == R.id.redScore){
            redScoreAction(v);
        }
        else if(id == R.id.redAce){
            redAceAction(v);
        }
        else if(id == R.id.redBlock){
            redBlockAction(v);
        }
        else if(id == R.id.redKill){
            redKillAction(v);
        }
        else if(id == R.id.redOppAttackErr){
            redOppAttackErrAction(v);
        }
        else if(id == R.id.redOppServeErr){
            redOppServeErrAction(v);
        }
        else if(id == R.id.redOppOtherErr){
            redOppOtherErrAction(v);
        }
        else if(id == R.id.redAttack){
            redAtkAction(v);
        }
        else if(id == R.id.redDig){
            redDigAction(v);
        }

        else if(id == R.id.redOne){
            redOneAction(v);
        }
        else if(id == R.id.redTwo){
            redTwoAction(v);
        }
        else if(id == R.id.redThree){
            redThreeAction(v);
        }
        // blue actions

        if(id == R.id.blueScore){
            blueScoreAction(v);
        }
        else if(id == R.id.blueAce){
            blueAceAction(v);
        }
        else if(id == R.id.blueBlock){
            blueBlockAction(v);
        }
        else if(id == R.id.blueKill){
            blueKillAction(v);
        }
        else if(id == R.id.blueOppAttackErr){
            blueOppAttackErrAction(v);
        }
        else if(id == R.id.blueOppServeErr){
            blueOppServeErrAction(v);
        }
        else if(id == R.id.blueOppOtherErr){
            blueOppOtherErrAction(v);
        }
        else if(id == R.id.blueAttack){
            blueAtkAction(v);
        }
        else if(id == R.id.blueDig){
            blueDigAction(v);
        }

        else if(id == R.id.blueOne){
            blueOneAction(v);
        }
        else if(id == R.id.blueTwo){
            blueTwoAction(v);
        }
        else if(id == R.id.blueThree){
            blueThreeAction(v);
        }




        updateScreen();
    }
}