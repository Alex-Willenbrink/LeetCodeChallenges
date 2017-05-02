/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep49v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP49V3 {

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> outputStrings = new ArrayList<List<String>>();
        outputStrings.add(new ArrayList<String>());
        outputStrings.get(0).add(strs[0]);
        
        for(int i = 1; i < strs.length; i++){
            for(int j = 0; j < outputStrings.size(); j++){
                if(isAnagram(strs[i], outputStrings.get(j).get(0))){
                    outputStrings.get(j).add(strs[i]);
                    break;
                }
            }
            outputStrings.add(new ArrayList<String>());
            outputStrings.get(outputStrings.size() - 1).add(strs[0]);
        }
        return outputStrings;
    }
    
    public static boolean isAnagram(String firstWord, String secondWord){
        char[] word1 = firstWord.toCharArray();
        char[] word2 = secondWord.toCharArray();
        
        Arrays.sort(word1);
        Arrays.sort(word2);
        
        return Arrays.equals(word1, word2);
    }
    
    
    public static void main(String[] args) {
        String[] strs = new String[]{"something", "alsosomething"};
        List<List<String>> output = groupAnagrams(strs);
    }
    
}
