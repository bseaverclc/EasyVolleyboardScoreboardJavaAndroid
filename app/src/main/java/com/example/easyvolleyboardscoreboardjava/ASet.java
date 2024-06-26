package com.example.easyvolleyboardscoreboardjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ASet  {
    private Map<String, Integer> redStats;
    private Map<String, Integer> blueStats;
    private String serve;
    private int redRotation;
    private int blueRotation;
    private ArrayList<Integer> redRotationPlusMinus;
    private ArrayList<Integer> blueRotationPlusMinus;
    private ArrayList<Point> pointHistory;
    private int redScore;
    private int blueScore;
    private String uid;
    private int redAttack;
    private int redOne;
    private int redTwo;
    private int redThree;
    private int blueAttack;
    private int blueOne;
    private int blueTwo;
    private int blueThree;
    private int redDigs;
    private int blueDigs;

    public ASet() {
        redStats = new HashMap<>();
        redStats.put("Ace", 0);
        redStats.put("Kill", 0);
        redStats.put("Block", 0);
        redStats.put("Opponent Err", 0);
        redStats.put("Opponent Serve Err", 0);
        redStats.put("redScore", 0);
        redStats.put("Opponent Attack Err", 0);

        blueStats = new HashMap<>();
        blueStats.put("Ace", 0);
        blueStats.put("Kill", 0);
        blueStats.put("Block", 0);
        blueStats.put("Opponent Err", 0);
        blueStats.put("Opponent Serve Err", 0);
        blueStats.put("blueScore", 0);
        blueStats.put("Opponent Attack Err", 0);

        serve = "red";
        redRotation = 0;
        blueRotation = 0;
        redRotationPlusMinus = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            redRotationPlusMinus.add(0);
        }
        blueRotationPlusMinus = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            blueRotationPlusMinus.add(0);
        }
        pointHistory = new ArrayList<>();
        redScore = 0;
        blueScore = 0;
    }

    public ASet(String key, Map<String, Object> dict) {
        uid = key;
        redStats = (Map<String, Integer>) dict.get("redStats");
        blueStats = (Map<String, Integer>) dict.get("blueStats");
        if (dict.containsKey("serve")) {
            serve = (String) dict.get("serve");
        }
        if (dict.containsKey("redRotation")) {
            redRotation = (int) dict.get("redRotation");
        }
        if (dict.containsKey("blueRotation")) {
            blueRotation = (int) dict.get("blueRotation");
        }
        if (dict.containsKey("redRotationPlusMinus")) {
            redRotationPlusMinus = (ArrayList<Integer>) dict.get("redRotationPlusMinus");
        }
        if (dict.containsKey("blueRotationPlusMinus")) {
            blueRotationPlusMinus = (ArrayList<Integer>) dict.get("blueRotationPlusMinus");
        }
        if (dict.containsKey("redAttack")) {
            redAttack = (int) dict.get("redAttack");
        }
        if (dict.containsKey("redOne")) {
            redOne = (int) dict.get("redOne");
        }
        if (dict.containsKey("redTwo")) {
            redTwo = (int) dict.get("redTwo");
        }
        if (dict.containsKey("redThree")) {
            redThree = (int) dict.get("redThree");
        }
        if (dict.containsKey("blueAttack")) {
            blueAttack = (int) dict.get("blueAttack");
        }
        if (dict.containsKey("blueOne")) {
            blueOne = (int) dict.get("blueOne");
        }
        if (dict.containsKey("blueTwo")) {
            blueTwo = (int) dict.get("blueTwo");
        }
        if (dict.containsKey("blueThree")) {
            blueThree = (int) dict.get("blueThree");
        }
        if (dict.containsKey("redDigs")) {
            redDigs = (int) dict.get("redDigs");
        }
        if (dict.containsKey("blueDigs")) {
            blueDigs = (int) dict.get("blueDigs");
        }
    }

    public void addPoint(Point point, String gameUid) {
        pointHistory.add(point);
        System.out.println("added a point from addPoint(point: Point) function");
//        if (uid != null) {
//            DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
//                    .child("games")
//                    .child(gameUid)
//                    .child("sets")
//                    .child(uid)
//                    .child("pointHistory");
//            point.uid = ref.child(ref.push().getKey()).getKey();
//            Map<String, Object> pointDict = new HashMap<>();
//            pointDict.put("serve", point.serve);
//            pointDict.put("redRotation", point.redRotation);
//            pointDict.put("blueRotation", point.blueRotation);
//            pointDict.put("who", point.who);
//            pointDict.put("why", point.why);
//            pointDict.put("score", point.score);
//            ref.child(point.uid).updateChildren(pointDict);
//            System.out.println("added point with key " + point.uid);
//        } else {
//            System.out.println("Error trying to add point to firebase, no uid?");
//        }
    }

    public void addPoint(String key, Map<String, Object> dict) {
        pointHistory.add(new Point(key, dict));
        System.out.println("added a point from addPoint(key, dict) function");
    }

//    public void deletePointFromFirebase(String gameUid, String euid) {
//        if (uid != null) {
//            pointHistory.remove(pointHistory.size() - 1);
//            System.out.println("Trying to remove point " + euid);
//            FirebaseDatabase.getInstance().getReference()
//                    .child("games")
//                    .child(gameUid)
//                    .child("sets")
//                    .child(uid)
//                    .child("pointHistory")
//                    .child(euid)
//                    .removeValue();
//            System.out.println("Point has been removed from Firebase");
//        } else {
//            System.out.println("Error Deleting Point! Point not in Firebase");
//        }
//    }
//
//    public void setUpdateSetInfoFirebase(String gameUid) {
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
//                .child("games")
//                .child(gameUid)
//                .child("sets");
//        Map<String, Object> setDict = new HashMap<>();
//        setDict.put("redStats", redStats);
//        setDict.put("blueStats", blueStats);
//        setDict.put("serve", serve);
//        setDict.put("redRotation", redRotation);
//        setDict.put("blueRotation", blueRotation);
//        setDict.put("redRotationPlusMinus", redRotationPlusMinus);
//        setDict.put("blueRotationPlusMinus", blueRotationPlusMinus);
//        setDict.put("redAttack", redAttack);
//        setDict.put("redOne", redOne);
//        setDict.put("redTwo", redTwo);
//        setDict.put("redThree", redThree);
//        setDict.put("blueAttack", blueAttack);
//        setDict.put("blueOne", blueOne);
//        setDict.put("blueTwo", blueTwo);
//        setDict.put("blueThree", blueThree);
//        setDict.put("redDigs", redDigs);
//        setDict.put("blueDigs", blueDigs);
//        ref.child(uid).updateChildren(setDict);
//    }
//
//    public void setUpdateFirebase(String gameUid) {
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
//                .child("games")
//                .child(gameUid)
//                .child("sets");
//        Map<String, Object> setDict = new HashMap<>();
//        setDict.put("redStats", redStats);
//        setDict.put("blueStats", blueStats);
//        setDict.put("serve", serve);
//        setDict.put("redRotation", redRotation);
//        setDict.put("blueRotation", blueRotation);
//        setDict.put("redRotationPlusMinus", redRotationPlusMinus);
//        setDict.put("blueRotationPlusMinus", blueRotationPlusMinus);
//        setDict.put("redAttack", redAttack);
//        setDict.put("redOne", redOne);
//        setDict.put("redTwo", redTwo);
//        setDict.put("redThree", redThree);
//        setDict.put("blueAttack", blueAttack);
//        setDict.put("blueOne", blueOne);
//        setDict.put("blueTwo", blueTwo);
//        setDict.put("blueThree", blueThree);
//        setDict.put("redDigs", redDigs);
//        setDict.put("blueDigs", blueDigs);
//        ref.child(uid).updateChildren(setDict);
//
//        for (Point point : pointHistory) {
//            Map<String, Object> pointDict = new HashMap<>();
//            pointDict.put("serve", point.serve);
//            pointDict.put("redRotation", point.redRotation);
//            pointDict.put("blueRotation", point.blueRotation);
//            pointDict.put("who", point.who);
//            pointDict.put("why", point.why);
//            pointDict.put("score", point.score);
//            if (point.uid.isEmpty()) {
//                DatabaseReference pointRef = ref.child(uid).child("pointHistory");
//                point.uid = pointRef.push().getKey();
//                System.out.println("added point with key " + point.uid);
//            }
//            ref.child(uid).child("pointHistory").child(point.uid).updateChildren(pointDict);
//        }
//    }

    public Map<String, Integer> getRedStats() {
        return redStats;
    }

    public void setRedStats(Map<String, Integer> redStats) {
        this.redStats = redStats;
    }

    public Map<String, Integer> getBlueStats() {
        return blueStats;
    }

    public void setBlueStats(Map<String, Integer> blueStats) {
        this.blueStats = blueStats;
    }

    public String getServe() {
        return serve;
    }

    public void setServe(String serve) {
        this.serve = serve;
    }

    public int getRedRotation() {
        return redRotation;
    }

    public void setRedRotation(int redRotation) {
        this.redRotation = redRotation;
    }

    public int getBlueRotation() {
        return blueRotation;
    }

    public void setBlueRotation(int blueRotation) {
        this.blueRotation = blueRotation;
    }

    public ArrayList<Integer> getRedRotationPlusMinus() {
        return redRotationPlusMinus;
    }

    public void setRedRotationPlusMinus(ArrayList<Integer> redRotationPlusMinus) {
        this.redRotationPlusMinus = redRotationPlusMinus;
    }

    public ArrayList<Integer> getBlueRotationPlusMinus() {
        return blueRotationPlusMinus;
    }

    public void setBlueRotationPlusMinus(ArrayList<Integer> blueRotationPlusMinus) {
        this.blueRotationPlusMinus = blueRotationPlusMinus;
    }

    public ArrayList<Point> getPointHistory() {
        return pointHistory;
    }

    public void setPointHistory(ArrayList<Point> pointHistory) {
        this.pointHistory = pointHistory;
    }

    public int getRedScore() {
        return redScore;
    }

    public void setRedScore(int redScore) {
        this.redScore = redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }

    public void setBlueScore(int blueScore) {
        this.blueScore = blueScore;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getRedAttack() {
        return redAttack;
    }

    public void setRedAttack(int redAttack) {
        this.redAttack = redAttack;
    }

    public int getRedOne() {
        return redOne;
    }

    public void setRedOne(int redOne) {
        this.redOne = redOne;
    }

    public int getRedTwo() {
        return redTwo;
    }

    public void setRedTwo(int redTwo) {
        this.redTwo = redTwo;
    }

    public int getRedThree() {
        return redThree;
    }

    public void setRedThree(int redThree) {
        this.redThree = redThree;
    }

    public int getBlueAttack() {
        return blueAttack;
    }

    public void setBlueAttack(int blueAttack) {
        this.blueAttack = blueAttack;
    }

    public int getBlueOne() {
        return blueOne;
    }

    public void setBlueOne(int blueOne) {
        this.blueOne = blueOne;
    }

    public int getBlueTwo() {
        return blueTwo;
    }

    public void setBlueTwo(int blueTwo) {
        this.blueTwo = blueTwo;
    }

    public int getBlueThree() {
        return blueThree;
    }

    public void setBlueThree(int blueThree) {
        this.blueThree = blueThree;
    }

    public int getRedDigs() {
        return redDigs;
    }

    public void setRedDigs(int redDigs) {
        this.redDigs = redDigs;
    }

    public int getBlueDigs() {
        return blueDigs;
    }

    public void setBlueDigs(int blueDigs) {
        this.blueDigs = blueDigs;
    }
}


