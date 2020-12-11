package Exercises;

import java.util.HashMap;
import java.util.HashSet;

public class RepeatedChar {

    HashSet<Character> set = new HashSet<>();

    public char findRepeatedChar(String str){

        char [] chars = str.toCharArray();
        for(char chr : chars){
            if(set.contains(chr)){
                return chr;
            }
            else set.add(chr);
        }
        return  Character.MIN_VALUE;
    }
}
