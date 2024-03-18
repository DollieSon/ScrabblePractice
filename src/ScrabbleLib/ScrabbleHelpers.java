package ScrabbleLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ScrabbleHelpers {


    private ScrabbleHelpers(){

    }

    public static String sortString(String word){
        char[] char_arr = word.toCharArray();
        Arrays.sort(char_arr);
        return String.valueOf(char_arr);
    }


}