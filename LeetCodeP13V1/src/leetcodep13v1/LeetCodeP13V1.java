/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep13v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP13V1 {

    /**
     * @param args the command line arguments
     */
    
    public static int romanChartoInt(char c){
        if(c == 'I'){
            return 1;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'D'){
            return 500;
        }else if(c == 'M'){
            return 1000;
        }else{
            return 0;
        }
    }
    
    public static int romanToInt(String s){
        char[] sChar = s.toCharArray();
        int output = romanChartoInt(sChar[sChar.length-1]), last = output, current;
        
        for(int i = sChar.length-2; i > -1; i--){
            current = romanChartoInt(sChar[i]);
            if(last > current){
                output = output - current;
            }else{
                output = output + current;
            }
            last = current;
        }
        return output;
    }
    
    public static void main(String[] args) {
        String s = new String("MCLDM");
        
        System.out.println(romanToInt(s));
        
        
    }
    
}
