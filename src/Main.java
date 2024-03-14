import ScrabbleLib.DictionaryCollin;
import ScrabbleLib.WordGenerator;
import ScrabbleLib.WordGroup;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        WordGenerator Wg = new WordGenerator("Hello");
        Set<String> combs = Wg.GetCombinations();
        ArrayList<WordGroup> some = Wg.getValidWords();

        System.out.println("Done");
    }

    public void StartGame(){

    }


}
