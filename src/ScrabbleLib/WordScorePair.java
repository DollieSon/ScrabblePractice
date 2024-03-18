package ScrabbleLib;

import java.util.Comparator;

public class WordScorePair {
    int Score;
    String Word;

    public WordScorePair(int score, String word) {
        Score = score;
        Word = word;
    }
    public static Comparator<WordScorePair> SortByScoreDec = (o1, o2) -> Integer.compare(o1.Score,o2.Score);
}
