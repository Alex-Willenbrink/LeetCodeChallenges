/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep66v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP66V1 {

    public static int[] plusOne(int[] digits){
        // Check for all 9's, the only situation where we need to make another array
        boolean allNines = true;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                allNines = false;
                break;
            }
        }
        
        int[] outputDigits;
        if(allNines){
            outputDigits = new int[digits.length + 1];
            for(int i = digits.length - 1; i > -1; i--){
                outputDigits[i + 1] = digits[i];
            }
            outputDigits[0] = 1;
        } else{
            outputDigits = new int[digits.length];
            for(int i = digits.length - 1; i > -1; i--){
                outputDigits[i] = digits[i];
            }
        }
        
        
        int indexOriginal = digits.length - 1, indexNew = outputDigits.length - 1;
        // make a while loop for the increase
        
        while(indexOriginal > -1){
            if(digits[indexOriginal] == 9){
                outputDigits[indexNew] = 0;
                indexNew--; indexOriginal--;
            } else{
                outputDigits[indexNew] += 1;
                return outputDigits;
            }
        }
        
        return outputDigits;
    }
    
    public static void printNum(int[] num){
        for(int i = 0; i < num.length; i++){
            System.out.printf("%d", num[i]);
        }
        System.out.printf("\n");
    }
    
    public static void main(String[] args) {
        int[] numIn = new int[]{9,9,9,9,9};
        
        printNum(plusOne(numIn));
    }
    
}
