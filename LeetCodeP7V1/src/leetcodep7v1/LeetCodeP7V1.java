/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep7v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP7V1 {

    /**
     * @param args the command line arguments
     */
    
    public static int reverse(int x){
        
        long numB = 0;
        
        while(x!=0){
            
            // Check for overflow
            numB = numB*10;
            numB = numB + x%10;
            if((numB > Integer.MAX_VALUE) || (numB*-1 > Integer.MAX_VALUE)) return 0;
            x = x/10;
        }
        
        return (int) numB;
    }
    
    public static void main(String[] args) {
        
        int num = -1147483699;
        
        int numB = reverse(num);
        
        System.out.println(numB);
    }
    
}
