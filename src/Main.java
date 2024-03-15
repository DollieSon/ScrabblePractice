import ScrabbleLib.RandGen;
import ScrabbleLib.WordCombinator;
import ScrabbleLib.WordGroup;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        StartGame();


      }
    public static void StartGame(){
        boolean isGaming =true;
        int wordcount = 5;
        while(isGaming){
            //ask for wordcount
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the wordcount");
            wordcount = sc.nextInt();
            sc.nextLine();
            RandGen CharGen = new RandGen(wordcount);
            String charSet = CharGen.getRandString();
            WordCombinator Combi = new WordCombinator(charSet);
            HashMap<String, WordGroup> HG = Combi.getMappedWords();



            //Continue or Quit
            System.out.println("Quit or Continue?: Y/N");
            String answer = sc.nextLine();
            if(answer.equals("N")){
                isGaming = false;
            }
        }
    }



}
