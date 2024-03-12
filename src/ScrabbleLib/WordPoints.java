package ScrabbleLib;

import java.awt.*;
import java.util.*;
import java.util.List;

public class WordPoints {
    static private final ArrayList<Integer> PointChar;

    static {
        PointChar = new ArrayList<>();
        Integer[] TempChar;
        TempChar = new Integer[]{
              //A B C D E F G H I J K L M N O P  Q R S T U V W X Y Z
                1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10
        };
        PointChar.addAll(List.of(TempChar));
    }



    public static int getPoints(String word){

        ArrayList<Integer> mymult = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            mymult.add(1);
        }
        return getPoints(word,mymult);
    }
    public static int getPoints(String word, List<Integer> mult) throws RuntimeException{
        word = word.toLowerCase();
        if(mult.size() != word.length()) throw new RuntimeException("word and mult is not the same len");
        int points = 0;
        for (int i = 0; i < word.length(); i++) {
            try{
                points += PointChar.get((int)word.charAt(i) -97) * mult.get(i);
            }catch (Exception e){
                System.out.println("something went wrong XD");
            }
        }
        return points;
    }

}
