/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep35v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP35V1 {

    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid = (low+high)/2;
        
        // Make sure it's at least possibly inside the num array
        if(target < nums[low]) return 0;
        if(target > nums[high]) return high+1;
        
        while(high >= low){
            if(target < nums[mid]){
                high = mid-1;
                mid = (low+high)/2;
            }else if(target > nums[mid]){
                low = mid + 1;
                mid = (low+high)/2;
            }else{
                if(nums[mid] == target) return mid; // Return if found target... obviously
                
                mid = (high+low)/2;
            }
        }
        return low + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        
        System.out.println(searchInsert(nums, 4));
    }
    
}
