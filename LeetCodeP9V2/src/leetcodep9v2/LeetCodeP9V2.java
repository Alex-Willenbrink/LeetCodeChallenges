/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep9v2;

/**
 *
 * @author Alex
 */
public class LeetCodeP9V2 {

    /**
     * @param args the command line arguments
     */
    public static boolean isPalindrome(int x) {

        if(x < 0) return false;
        
        if(x < 10) return true;
        
        // Find number of digits in input
        int dNum = (int) Math.log10(x)+ 1;

        int[] dArray = new int[dNum];

        // Put the digits in our dArray for later analysis
        for (int i = 0; i < dNum; i++) {
            dArray[i] = x % 10;
            x = x / 10;
        }

        // Compares each digit in the sequence
        for (int i = 0; i < dNum / 2; i++) {
            if (dArray[i] != dArray[dNum - i - 1]) {
                return false;
            }
        }
        
        return true;
    }

    
    public static void main(String[] args) {
        
        System.out.println(isPalindrome(1098901));
    }
    
}
