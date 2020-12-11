package Exercises;

import java.util.HashMap;

public class FirstNonRepeating {
    HashMap<Character, Integer> map = new HashMap<>();

    public Character findFirstNonRepeating(String str){

        char [] chars = str.toCharArray();
        int value ;
        for (int i = 0; i < chars.length; i++) {

            if(map.containsKey(chars[i])){
                value = map.get(chars[i]);
                value++;
            }
            else {
                value = 1;
            }
            map.put(chars[i], value);

        }
        for (char item: chars
             ) {
            if(map.get(item) == 1){
                return item;
            }
        }
        return null;
    }

    public void printMap(){
        System.out.println(map);
    }
}
