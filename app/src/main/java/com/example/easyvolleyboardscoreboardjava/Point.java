package com.example.easyvolleyboardscoreboardjava;


//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Point {
    private String serve;
    private int redRotation;
    private int blueRotation;
    private String who;
    private String why;
    private String score;
    private String uid = "";

    public Point(String serve, int redRotation, int blueRotation, String who, String why, String score) {
        this.serve = serve;
        this.redRotation = redRotation;
        this.blueRotation = blueRotation;
        this.who = who;
        this.why = why;
        this.score = score;
    }

    public Point(String key, Map<String, Object> dict) {
        this.uid = key;
        this.serve = (String) dict.get("serve");
        this.redRotation = (int) dict.get("redRotation");
        this.blueRotation = (int) dict.get("blueRotation");
        this.who = (String) dict.get("who");
        this.why = (String) dict.get("why");
        this.score = (String) dict.get("score");
    }

    // Getters and Setters (if needed)
}

