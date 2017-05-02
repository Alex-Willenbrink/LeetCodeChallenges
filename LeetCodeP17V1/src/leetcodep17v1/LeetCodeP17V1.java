/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep17v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP17V1 {

     
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
        
        List<String> stringList = new ArrayList<>();
        stringList.add(new String(""));
        
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
    }
            
            
            
    public static void main(String[] args) {
        List<String> stringList = letterCombinations("2345");
        
        for(int i = 0; i < stringList.size(); i++){
            System.out.println(stringList.get(i));
        }
        
        
        System.out.println(stringList.size());
    }
    
}
