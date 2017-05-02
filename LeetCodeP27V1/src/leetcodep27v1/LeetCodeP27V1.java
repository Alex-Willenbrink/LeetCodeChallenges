/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep27v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP27V1 {

    public static int removeElement(int[] nums, int val){
        int i = 0, j = nums.length-1;
        
        // Check to find our first j number
        while(j > -1){
            if(nums[j] == val){
                j--;
            }else break;
        }
        
        if(j < 0) return 0; // Make sure we start with at least one number
        
        
        while(j >= i){
            if(nums[i] == val){
                nums[i] = nums[j];
                
                if(i == j-1){
                    return j;
                }else{
                    j--; // Go to new number
                }
                
                // Search for new number if applicable
                while(nums[j] == val){
                    j--;
                    if(i >= j) return j+1;
                }
            }
            i++;
        }
        return j+1;
    }
    
    
    
    public static void main(String[] args) {
        
        int[] num = new int[]{4,3,4,3,3,4,4};
        
        System.out.println(removeElement(num, 3));
        
        for(int i = 0; i < num.length; i++){
            System.out.printf("%d ", num[i]);
        }
        
        System.out.println();
        
    }
    
}
