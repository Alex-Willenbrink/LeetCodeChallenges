/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep70v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP70V1 {

    public static int climbStairs(int n) {
        
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                array[i] = 1;
            } else if(i == 1) {
                array[i] = 2;
            } else{
                array[i] = array[i - 1] + array[i -2];
            }  
        }
        return array[n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
    
}
