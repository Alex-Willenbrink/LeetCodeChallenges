/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep38v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP38V1 {

    public static String countAndSayFunction(String num){
        
        Integer countPos = 0, countFreq = 1;
        
        StringBuilder str = new StringBuilder();

        while(countPos < num.length()){
            if(countPos + countFreq >= num.length()){
                str.append(countFreq.toString()).append(num.charAt(countPos));
                countPos += countFreq;
            } else if(num.charAt(countPos) == num.charAt(countPos + countFreq)){
                countFreq++;
            } else{
                str.append(countFreq.toString()).append(num.charAt(countPos));
                countPos += countFreq;
                countFreq = 1; // Reset countFreq
            } 
        }
        return str.toString();
    }
    
    public static String countAndSay(int n){
        String str = new String("1");
        
        for(int i = 0; i < n - 1; i++){
            str = countAndSayFunction(str);
        }
        
        return str;
    }
    
    
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        
    }
    
}
