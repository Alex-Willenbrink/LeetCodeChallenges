/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep17v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP17V2 {

    public static List<String> letterCombinations(String digits){
        if(digits.length() < 1 ){
            return new ArrayList<String>();
        } else if(digits.contains("0") || digits.contains("1")){
            return new ArrayList<String>();
        }
        
        HashMap<Character, String> phoneMap = new HashMap<>();
        
        phoneMap.put('0', "");
        phoneMap.put('1', "");
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        
        // Find total number of StringBuilders to make
        int totalItems = 1;
        for(int i = 0; i < digits.length(); i++){
            totalItems *= phoneMap.get(digits.charAt(i)).length();
        }
        
        // Make StringBuilder Objects in List
        List<StringBuilder> stringList = new ArrayList<>();
        for(int i = 0; i < totalItems; i++){
            stringList.add(new StringBuilder());
        }
        
        /* 
        I think a double for loop will do it
        1 for the pattern
        another for the number of repeats of the pattern
        */
        
        for(int i = 0; i < )
        
        /*
        // For all digits in input string
        for(int i = 0; i < digits.length(); i++){
            List<String> stringListNew = new ArrayList<>();
            // For all items in list
            for(int j = 0; j < stringList.size(); j++){
                // For all digits associated with this number
                for(int k = 0; k < phoneMap.get(digits.charAt(i)).length(); k++){
                    Character character = phoneMap.get(digits.charAt(i)).charAt(k);
                    stringListNew.add(stringList.get(j) + character);
                }
            }
            stringList = stringListNew;
        }
        return stringList;
        */
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
