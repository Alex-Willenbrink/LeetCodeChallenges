/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep28v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP28V1 {

   
    public static int strStr(String haystack, String needle){
        
        if(!needle.isEmpty() && haystack.isEmpty() ) return -1;
        
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        
        if(haystackChar.length < needleChar.length) return -1;
        
        int count;
        
        for(int i = 0; i < (haystackChar.length - needleChar.length + 1); i++){
            count = 0;
            for(int j = 0; j < needleChar.length; j++){
                if(haystackChar[i+j] == needleChar[j]) count++;
                else break;
            }
            if(count == needleChar.length) return i;
        }
        
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("mi", "a"));
        String ans = "";
        System.out.println(ans.isEmpty());
    }
    
}
