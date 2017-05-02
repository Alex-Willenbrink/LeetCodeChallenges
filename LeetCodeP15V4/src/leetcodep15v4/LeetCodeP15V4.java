/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep15v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP15V4 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Base case, make sure that nums has greater than 2 digits
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums); // Sort array first

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result; // Increases efficiency like crazy
            }
            // First takes care of repeat i's
            if (i == 0 || nums[i] != nums[i - 1]) {
                // Initialize j
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) { 
                    if(nums[i] + nums[j] + nums[k] == 0){
                        // Found match add result 
                        List<Integer> addThis = new ArrayList<Integer>();
                        addThis.add(nums[i]);
                        addThis.add(nums[j]);
                        addThis.add(nums[k]);

                        result.add(addThis);

                        // Find new j
                        j++;
                        k--;
                        while (j < k && nums[j-1] == nums[j]) j++;  
                        // Find new k
                        while(j < k && nums[k] == nums[k+1]) k--;
                    } else if(nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else{
                        k--;
                    }
                }  
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-1,-1,0,1};
        
        List<List<Integer>> result = threeSum(nums);
        
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%d, %d, %d\n",result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
    }

}
