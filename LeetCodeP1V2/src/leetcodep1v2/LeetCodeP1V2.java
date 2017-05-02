/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep1v2;

/**
 *
 * @author Alex
 */
public class LeetCodeP1V2 {

    
    public static int[] twoSum(int[] nums, int target){
        
        // Make room for hash table
        HashTable hashTable = new HashTable(nums.length*6);
        
        // Insert all values into our hashtable
        for(int i = 0; i < nums.length; i++){
            hashTable.insertHashValue(nums[i], i);
        }
        
        int search;
        Integer index;
        
        for(int i = 0; i < nums.length; i++){
            search = target - nums[i];
            index = hashTable.findHashValue(search);
            if((index != null) && (index != i)){
                return new int[]{i, index};
            }
        }

        return null;
    }
    
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{3,-1,4,2};
        
        int[] ans = twoSum(nums, 6);
        System.out.printf("%d, %d\n", ans[0], ans[1]);
    }
    
}
