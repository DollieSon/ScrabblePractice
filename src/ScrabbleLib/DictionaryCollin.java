package ScrabbleLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DictionaryCollin {
    HashMap<String,WordGroup> WordScoreMap;

    public DictionaryCollin(){
        /*
         * "Sorted" {
         *       "Unsorted" : set
         *      Score
         *  }
         *
         *
        */

        WordScoreMap = new HashMap<>();

        File dictextfile = new File("./ExternFiles/WordList.txt");
        Scanner Reader;
        try {
            Reader = new Scanner(dictextfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(Reader.hasNextLine()){
            String word = Reader.nextLine();
            String sorted = sortString(word);
            if(!WordScoreMap.containsKey(sorted)){
                WordScoreMap.put(sorted,new WordGroup(sorted));
            }
            WordScoreMap.get(sorted).group.add(word);
        }
    }

    public int getWord(String word){

        String sorted = sortString(word);
        if(WordScoreMap.get(sorted).group.contains(sorted)){
            return WordScoreMap.get(sorted).score;
        }
        return -1;
    }
    //Helper Function
    public static String sortString(String word){
        char[] char_arr = word.toCharArray();
        Arrays.sort(char_arr);
        String sorted = String.valueOf(char_arr);
        return sorted;
    }
}
