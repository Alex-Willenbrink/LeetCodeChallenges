/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep9v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP9V1 {

    /**
     * @param args the command line arguments
     */
    
    
    public static boolean isPalindrome(int x){
        if(x < 10){
            return true;
        }
        
        int tenFactor = (int) Math.log10(x);
        if((tenFactor%2) == 0){
            
        }
        
        int y = (int) (x / Math.pow(10, tenFactor));
        int z = x%10;
        
        if( y == z){
            x = x - z;
            x = (int) (x - y*Math.pow(10, tenFactor));
            x = x / 10;
            return isPalindrome(x);
        }else{
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        
        int x = 191;
        
        int tenFactor = (int) Math.log10(x);
        System.out.println(tenFactor);
        
        int y = (int) (x / Math.pow(10, tenFactor));
        System.out.println(y);
        
        int z = x%10;
        System.out.println(z);
        
        x = x - z;
        x = (int) (x - y*Math.pow(10, tenFactor));
        //x = x / 10;
        System.out.println(x);
        
        //System.out.println(isPalindrome(x));
    }
    
}
