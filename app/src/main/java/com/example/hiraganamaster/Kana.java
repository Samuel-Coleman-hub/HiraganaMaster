package com.example.hiraganamaster;

public class Kana {
    private String kana;
    private String romanji;
    private int score = 50;

    private final int MAX_SCORE = 100;
    private final int MIN_SCORE = 0;

    public Kana(String kana, String romanji)
    {
        this.kana = kana;
        this.romanji = romanji;
    }

    public String getKana()
    {
        return kana;
    }

    public String getRomanji()
    {
        return romanji;
    }

    public int getScore()
    {
        return score;
    }

    public void increaseScore()
    {
        if(score + 1 != MAX_SCORE)
        {
            score += 1;
        }
    }

    public void decreaseScore()
    {
        if(score - 1 != MIN_SCORE)
        {
            score -= 1;
        }
    }

    public void resetScore()
    {
        score = 0;
    }

}
