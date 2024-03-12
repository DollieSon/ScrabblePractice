package ScrabbleLib;

import java.util.HashSet;
import java.util.Set;

public class WordGroup{
    public Set<String> group;
    public int score;

    WordGroup(String word){
        group = new HashSet<>();
        score = WordPoints.getPoints(word);
    }
}
