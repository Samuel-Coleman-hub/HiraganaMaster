package com.example.hiraganamaster;

import android.hardware.lights.LightState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

//Singleton Class to store kana data to be accessed globally
public class KanaData {
    private static KanaData instance;
    //private Map<String, Kana> kanaMap;
    private ArrayList<Kana> kanaList = new ArrayList<Kana>();

    private PriorityQueue<Kana> kanaQueue = new
            PriorityQueue<>((a, b) -> Integer.compare(a.getScore(), b.getScore()));

    private Kana currentKana;

    // Private constructor
    private KanaData() {
        //kanaMap = new HashMap<>();
        initializeKanaList();
        initializeKanaQueue();
    }

    // Public method to provide access to the instance
    public static synchronized KanaData getInstance() {
        if (instance == null) {
            instance = new KanaData();
        }
        return instance;
    }

    public Kana getNextKana()
    {
        currentKana = kanaQueue.poll();
        return currentKana;
    }

    public void correctKana()
    {
        currentKana.increaseScore();
        kanaQueue.add(currentKana);
    }

    public void falseKana()
    {
        currentKana.decreaseScore();
        kanaQueue.add(currentKana);
    }

    private void initializeKanaList()
    {
        kanaList.add(new Kana("あ", "a"));
        kanaList.add(new Kana("い", "i"));
        kanaList.add(new Kana("う", "u"));
        kanaList.add(new Kana("え", "e"));
        kanaList.add(new Kana("お", "o"));

        kanaList.add(new Kana("か", "ka"));
        kanaList.add(new Kana("き", "ki"));
        kanaList.add(new Kana("く", "ku"));
        kanaList.add(new Kana("け", "ke"));
        kanaList.add(new Kana("こ", "ko"));

        kanaList.add(new Kana("さ", "sa"));
        kanaList.add(new Kana("し", "shi"));
        kanaList.add(new Kana("す", "su"));
        kanaList.add(new Kana("せ", "se"));
        kanaList.add(new Kana("そ", "so"));

        kanaList.add(new Kana("た", "ta"));
        kanaList.add(new Kana("ち", "chi"));
        kanaList.add(new Kana("つ", "tsu"));
        kanaList.add(new Kana("て", "te"));
        kanaList.add(new Kana("と", "to"));

        kanaList.add(new Kana("な", "na"));
        kanaList.add(new Kana("に", "ni"));
        kanaList.add(new Kana("ぬ", "nu"));
        kanaList.add(new Kana("ね", "ne"));
        kanaList.add(new Kana("の", "no"));

        kanaList.add(new Kana("は", "ha"));
        kanaList.add(new Kana("ひ", "hi"));
        kanaList.add(new Kana("ふ", "fu"));
        kanaList.add(new Kana("へ", "he"));
        kanaList.add(new Kana("ほ", "ho"));

        kanaList.add(new Kana("ま", "ma"));
        kanaList.add(new Kana("み", "mi"));
        kanaList.add(new Kana("む", "mu"));
        kanaList.add(new Kana("め", "me"));
        kanaList.add(new Kana("も", "mo"));

        kanaList.add(new Kana("や", "ya"));
        kanaList.add(new Kana("ゆ", "yu"));
        kanaList.add(new Kana("よ", "yo"));

        kanaList.add(new Kana("ら", "ra"));
        kanaList.add(new Kana("り", "ri"));
        kanaList.add(new Kana("る", "ru"));
        kanaList.add(new Kana("れ", "re"));
        kanaList.add(new Kana("ろ", "ro"));

        kanaList.add(new Kana("わ", "wa"));
        kanaList.add(new Kana("を", "wo"));
        kanaList.add(new Kana("ん", "n"));
    }

    private void initializeKanaQueue()
    {
        kanaQueue.addAll(kanaList);
    }
}
