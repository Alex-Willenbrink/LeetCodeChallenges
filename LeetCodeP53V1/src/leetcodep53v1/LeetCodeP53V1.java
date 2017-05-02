/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep53v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP53V1 {

    public static int maxSubArray(int[] array, int low, int high){
        if(low == high) return array[low];
        
        int mid = (low + high) / 2;
        
        int leftSum = maxSubArray(array, low, mid);
        int rightSum = maxSubArray(array, mid + 1, high);
        int crossSum = findMaxCrossArray(array, low, mid, high);
        
        if(leftSum >= rightSum && leftSum >= crossSum){
            return leftSum;
        } else if (rightSum >= leftSum && rightSum >= crossSum){
            return rightSum;
        } else{
            return crossSum;
        }
        
    }
    
    public static int findMaxCrossArray(int[] array, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        
        
        // Find max subarray of left
        for(int i = mid; i > low - 1; i--){
            sum = sum + array[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        
        sum = 0; // Reset sum
        // Find max subarray of right
        for(int i = mid + 1; i < high + 1; i++){
            sum = sum + array[i];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        
        int[] sumArray = new int[]{leftSum, rightSum, leftSum + rightSum};
        return maxInt(sumArray);
    }
    
    public static int maxInt(int[] array){
        if(array.length < 0) return Integer.MIN_VALUE;
        int val = array[0];
        
        for(int i = 0; i < array.length; i++){
            if(val < array[i]){
                val = array[i];
            }
        }
        return val;
    }
    
    public static void main(String[] args) {
        //int[] array = new int[]{-1,-6,-9,4,-8,5,-4,2,-1,1,-8,0,1,3,1};
        int[] array = new int[]{5,-4,2,-1,1,-8,0,1,3,1};
        System.out.println(maxSubArray(array, 0, array.length -1));
    }
    
}
