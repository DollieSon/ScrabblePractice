package ScrabbleLib;

import java.util.*;

public class WordCombinator {
//    ArrayList<>
    //BitSet
    //Incremennt until 2 ^ wordlen
    char[] chars;
    String word;
    public WordCombinator(String word){
        this.word = ScrabbleHelpers.sortString(word.toLowerCase());
        chars = this.word.toCharArray();
    }

    public Set<String> GetCombinations(){
        Set<String> Combinations = new HashSet<>();
        int Max = (1 << word.length());
        System.out.println("Max: "+Max);
        BitSet chosen;
        String mWord; // maybe Word
        for (int i = 1; i < Max; i++) {
            chosen = intToBitset(i);
            mWord = bsToString(chosen);
            Combinations.add(mWord);
        }
        System.out.println("Found sets: " + Combinations.size());
        return Combinations;
    }
    //Helper Function
    private BitSet intToBitset(int Number){
        BitSet bs = new BitSet();
        int index   = 0;
        while(Number > 0){
            if(Number%2 == 1){
                bs.set(index);
            }
            Number /= 2;
            index++;
        }
        return bs;
    }

    //Helper Function
    private String bsToString(BitSet bs){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < bs.length(); i++) {
            if (bs.get(i)) {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }

    public ArrayList<WordGroup> getValidWords(){
        ArrayList<WordGroup> ValidWords = new ArrayList<>();
        Set<String> combinations = GetCombinations();
        WordGroup wg;
        DictionaryCollin dict = DictionaryCollin.getDictionaryCollin();
        for (String indiv: combinations.toArray(String[] :: new)) {
            wg = dict.getWordGroup(indiv);
            if(wg != null){
                ValidWords.add(wg);
            }
        }
        ValidWords.sort(WordGroup.DecreasingScore);
        return ValidWords;

    }
    public HashMap<String,WordGroup> getMappedWords(){
        ArrayList<WordGroup> ValWords = getValidWords();
        HashMap<String,WordGroup> VW = new HashMap<>();
        for(WordGroup group: ValWords) {
            VW.put(group.getSorted(),group);
        }
        return VW;
    }

}
