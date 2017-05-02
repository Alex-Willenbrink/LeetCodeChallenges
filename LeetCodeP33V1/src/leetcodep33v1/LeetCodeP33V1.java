/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep33v1;

import static java.util.Arrays.binarySearch;

/**
 *
 * @author Alex
 */
public class LeetCodeP33V1 {

    
    public static int search(int[] nums, int target) {
        // Make sure that we're given valid input
        if(nums.length < 1) return -1;
        
        // First to check if there is a pivot point at all
        if (nums[0] < nums[nums.length - 1]) {
            int test = binarySearch(nums, target);
            if(test < 0){
                return -1;
            } else{
                return test;
            }
        } else if(nums[0] == nums[nums.length - 1]){
            if(nums[0] != target){
                return -1;
            } else{
                return 0;
            }
        }

        
        // We know there is a pivot point, so we search for pivot high index
        int globalHighIndex = pivotBinaryHighSearch(nums);
        int globalLowIndex = globalHighIndex + 1;
        System.out.println("something");
        // Make sure number is between min and max before we continue
        if(target < nums[globalLowIndex] || target > nums[globalHighIndex]) return -1;
        
        int test = -1;
        // Do our binary search for the number in question
        if(target >= nums[0] && target <= nums[globalHighIndex]){
            test = binarySearch(nums, 0, globalHighIndex + 1, target);
        } else{
            test = binarySearch(nums, globalLowIndex, nums.length, target);
        }
        
        // Test test to make sure that it isn't a negative number, else we've found our bitch
        if(test < 0){
            return -1;
        } else{
            return test;
        }
    }
    
    
    public static int pivotBinaryHighSearch(int[] nums){
        int highLow = nums[0], lowHigh = nums[nums.length - 1];
        int low = 0, high = nums.length - 1, mid = (low + high) / 2;
        
        while(high >= low){
            if(nums[mid] <= lowHigh){
                high = mid - 1;
            } else if(nums[mid] >= highLow){
                low = mid + 1;
            } else{
                return mid;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        //int[] array = new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3};
        int[] arrayTest = new int[]{4,5,6,1,2,3,4};
        //System.out.println(pivotBinaryHighSearch(arrayTest));
        System.out.println(pivotBinaryHighSearch(arrayTest));
    }

}
