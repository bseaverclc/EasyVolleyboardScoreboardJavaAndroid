package com.example.easyvolleyboardscoreboardjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


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
        blueOneButton.setText("1\n" + set.getBlueOne());
        blueTwoButton.setText("2\n" + set.getBlueTwo());
        blueThreeButton.setText("3\n" + set.getBlueThree());
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
        set.setRedOne(set.getRedTwo() + 1);
    }
    public void redThreeAction(View view){
        set.setRedOne(set.getRedThree() + 1);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
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




        updateScreen();
    }
}