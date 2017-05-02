/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep58v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP58V1 {

    public static int lengthOfLastWord(String s){
        // Base case, make sure that word is longer than 0
        if(s.length() < 1) return 0;
        
        // Now we backtrack to find last space in the word
        int space = s.length() - 1;
        while(space > -1){
            if(s.charAt(space) == ' ') {
                space--;
            } else break;
        }
        
        // Make sure that space is less than 1
        if(space < 0) return 0;
        
        int count = 0;
        
        // Find longest word count
        while(space > -1){
            if(s.charAt(space) != ' '){
                count++;
                space--;
                
            } else break;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String s = new String(" f ");
        System.out.println(lengthOfLastWord(s));
    }
    
}
