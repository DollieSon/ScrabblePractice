package ScrabbleLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryCollin {
    //Make Sinlgeton?
    HashMap<String,WordGroup> WordScoreMap;
    static DictionaryCollin me;

    private DictionaryCollin(){
        WordScoreMap = new HashMap<>();

        File dictextfile = new File("./ExternFiles/WordList.txt");
        Scanner Reader;
        try {
            Reader = new Scanner(dictextfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(Reader.hasNextLine()){
            String word = Reader.nextLine().toLowerCase();
            String sorted = ScrabbleHelpers.sortString(word);
            if(!WordScoreMap.containsKey(sorted)){
                WordScoreMap.put(sorted,new WordGroup(sorted));
            }
            WordScoreMap.get(sorted).group.add(word);
        }
        Reader.close();
        System.out.println( WordScoreMap.containsKey("ehllo"));
    }

    public static DictionaryCollin getDictionaryCollin(){
        if(me == null){
            me = new DictionaryCollin();
        }
        return me;
    }


    public int getWord(String word){

        String sorted = ScrabbleHelpers.sortString(word);
        WordGroup wg = WordScoreMap.get(sorted);
        if(wg != null && wg.group.contains(sorted)){
            return WordScoreMap.get(sorted).score;
        }
        return -1;
    }
    //Helper Function

    //Send a SortedWord
    public WordGroup getWordGroup(String SortedWord){
        return WordScoreMap.get(SortedWord);
    }

}
