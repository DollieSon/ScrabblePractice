package ScrabbleLib;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class WordGroup{
    public Set<String> group;
    public int score;

    WordGroup(String word){
        group = new HashSet<>();
        score = WordPoints.getPoints(word);
    }
    public static Comparator<WordGroup> DecreasingScore = (o1, o2) -> Integer.compare(o2.score,o1.score);

    public String getSorted(){
        return ScrabbleHelpers.sortString(group.iterator().next());
    }

}
