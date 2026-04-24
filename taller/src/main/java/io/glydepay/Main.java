package io.glydepay;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Result " + checkString("abcd", "cdab"));
    }


    public static boolean checkString (String s1, String s2){
        char[] s1CharArray = s1.toCharArray();

        List<Character> stringToCheck = IntStream.range(0, s1CharArray.length)
                .mapToObj(i -> s1CharArray[i])
                .collect(Collectors.toList());

        for(int i = 0; i < s1.length(); i++){
            stringToCheck.remove(stringToCheck.get(0));
            stringToCheck.add(s1.length()-1, s1.charAt(i));

            String actualString = String.valueOf(stringToCheck);

            System.out.println("Test "+actualString + " " + s2);

            if(actualString.equals(s2)){
                return true;
            }
        }
        return false;
    }
}