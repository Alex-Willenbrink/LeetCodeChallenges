/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep15v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP15V3 {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Base case, make sure that nums has greater than 2 digits
        if(nums.length < 3) return result;
        
        Arrays.sort(nums); // Sort array first
        
        int j, target, k;
        for(int i = 0; i < nums.length - 2; i++){
            // First takes care of repeat i's
            if(i == 0 || nums[i] != nums[i-1]){
                // Initialize j
                j = i + 1;
                
                while(j < nums.length-1){
                    // Make sure we aren't wasting our time with this j value
                    if(nums[i] + nums[j] > 0){
                        break;
                    } else{
                    // Commit to a binary search to try and find the value
                        target = -(nums[i] + nums[j]);
                        k = binarySearch(nums, target, j+1, nums.length-1);
                        
                        if(j >= k) break;
                        
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> addThis = new ArrayList<Integer>();
                            addThis.add(nums[i]);
                            addThis.add(nums[j]);
                            addThis.add(nums[k]);
                            
                            result.add(addThis);
                        }
                        // Find new j
                        j++;
                        while(j < nums.length-1){
                            if(nums[j] == nums[j-1]){
                                j++;
                            }else{
                                break;
                            }
                        }
                        
                    }
                }
            }
                    
        }
        return result;
    }
    
    
    public static int binarySearch(int[] array, int value, int left, int right) {
          int middle = (left + right) / 2;
          
          if(left > right) return middle;
          
          if (array[middle] == value)
                return middle;
          else if (array[middle] > value)
                return binarySearch(array, value, left, middle - 1);
          else
                return binarySearch(array, value, middle + 1, right);           
    }
    
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,-2,-1};
        
        List<List<Integer>> result = threeSum(nums);
        
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%d, %d, %d\n",result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
        
        
        //Arrays.sort(nums);
        //int k = binarySearch(nums, -1, 0, nums.length-1);
        
        //System.out.println(k);
        
                
    }
    
}
