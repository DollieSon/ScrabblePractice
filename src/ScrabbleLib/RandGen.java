package ScrabbleLib;

import java.util.Random;

public class RandGen {
    String includedChars;
    Random randgen;
    int WordLen;

    int[] chances;

    public RandGen(String include,int wordLen){
        chances =
        new int[]{0,9,11,13,17,29,31,34,36,45,46,47,51,53,59,67,69,70,76,80,86,90,92,94,95,97,98};
        includedChars = include;
        randgen = new Random();
        WordLen = wordLen;
    }
    public RandGen(int wordLen){
        this("",wordLen);
    }

    //a = 97, b = 122
    public String getRandString(){
        StringBuilder RandedString = new StringBuilder();
        for (int i = 0; i < WordLen; i++) {
            int chosen = (randgen.nextInt(98));
            //System.out.println(i + ": " +chosen);
            RandedString.append(getChar(chosen));
        }
        return RandedString.toString();
    }
    //Helper Function
    private char getChar(int index){
        for (int i = 1; i < chances.length; i++) {
            if(index >= chances[i-1] && index < chances[i]){
                return (char) (i + 96);
            }
        }
        return '*';
    }

}
