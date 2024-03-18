import ScrabbleLib.RandGen;
import ScrabbleLib.ScrabbleHelpers;
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
            System.out.print("Enter the wordcount:");
            wordcount = sc.nextInt();
            sc.nextLine();
            RandGen CharGen = new RandGen(wordcount);
            String charSet = CharGen.getRandString();
            WordCombinator Combi = new WordCombinator(charSet);
            HashMap<String,WordGroup> Searched = Combi.getMappedWords();
            int HighestSCore = 0;
            int TotalScore =0;
            System.out.println("Characters: " + charSet);
            //Start Game
            System.out.println("Enter Your Words");
            int Tries = 2;
            while(Tries > 0){
                System.out.println("Tries Left: " + Tries);
                String theWord = sc.nextLine();
                System.out.println("Word is " + theWord);
                String sortedWord = ScrabbleHelpers.sortString(theWord);
                if(!Searched.containsKey(sortedWord)){
                    System.out.println(theWord + " is not Valid");
                    continue;
                }
                int Score = Searched.get(sortedWord).score;
                System.out.println("The Score is " + Score);
                TotalScore += Score;
                if(HighestSCore < Score){
                    HighestSCore = Score;
                }
                Tries--;
            }
            ArrayList<WordGroup> sortedWordGroup = Combi.getValidWords();
            System.out.println("List of Words are");
            int Ranking = 1;
            int MaxRanking = 50;
            int CurrentScore = -1;
            for(WordGroup wg: sortedWordGroup){
                if(CurrentScore != wg.score) {
                    System.out.println("Score : " + wg.score);
                    CurrentScore = wg.score;
                }
                Iterator<String> it = wg.group.iterator();
                while(it.hasNext()){
                    System.out.println((Ranking++) + ". " + it.next());
                }
                if(MaxRanking < Ranking){
                    break;
                }
            }
            //Continue or Quit
            System.out.println("Quit?: Y/N");
            String answer = sc.nextLine();
            if(answer.equals("Y")){
                isGaming = false;
            }
        }
    }



}
