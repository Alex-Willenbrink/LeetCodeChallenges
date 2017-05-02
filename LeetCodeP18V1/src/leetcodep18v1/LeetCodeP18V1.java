/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep18v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex
 */
public class LeetCodeP18V1 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();

        // Base case to make sure we have more than 3 numbers to work with
        if (nums.length < 4) {
            return solutionSet;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0) {
                if(nums[i] >= 0 && nums[i] > target){
                    return solutionSet;
                }
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - 1 != i) {
                    if (nums[j] == nums[j - 1]) {
                        continue;
                    }
                } else{
                    if(nums[i] + nums[j] >= 0 && nums[i] + nums[j] > target){
                        return solutionSet;
                    }
                }

                int k = j + 1;
                int m = nums.length - 1;

                while (m > k) {
                    // found target sequence
                    if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                        List<Integer> sequenceNew = new ArrayList<Integer>();
                        sequenceNew.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        solutionSet.add(sequenceNew);

                        // Find new k and m
                        k++;
                        m--;
                        while (k < m && nums[k - 1] == nums[k]) {
                            k++;
                        }
                        while (k < m && nums[m + 1] == nums[m]) {
                            m--;
                        }
                    } else if(nums[i] + nums[j] + nums[k] + nums[m] < target){
                        k++;
                    } else{
                        m--;
                    }
                }
            }
        }

        return solutionSet;
    }
    
    public static void printSolution(List<List<Integer>> solutionSet){
        for(int i = 0; i < solutionSet.size(); i++){
            for(int j = 0; j < solutionSet.get(i).size(); j++){
                System.out.printf("%d ", solutionSet.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};
        
        List<List<Integer>> answer = fourSum(nums, 4);
        printSolution(answer);
    }

}
