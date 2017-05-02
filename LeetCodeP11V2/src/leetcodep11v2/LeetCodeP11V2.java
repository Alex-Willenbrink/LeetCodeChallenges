/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep11v2;

public class LeetCodeP11V2 {

    public static AreaArray findMaxArea(int[] array, int low, int mid, int high, int area) {

        int areaLoc, lowCol = 0;
        for (int i = high; i > mid; i--) {
            for (int j = low; j < mid + 1; j++) {

                // Check to see if theoretical value is less than current area
                if (array[i] * (i - j) < area) {
                    break;
                }

                // Find lowest column for finding area
                if (array[i] > array[j]) {
                    lowCol = array[j];
                } else {
                    lowCol = array[i];
                }

                // Calculate area and if greater than current area, replace value
                areaLoc = (i - j) * lowCol;
                if (areaLoc > area) {
                    area = areaLoc;
                }
            }
        }
        return new AreaArray(low, high, area);
    }
    
    public static AreaArray findMaxSubarray(int[] array, int low, int high){
        if(low == high) return new AreaArray(low, high, 0);
        
        int mid = (high+low)/2;
        
        AreaArray arrayLeft = findMaxSubarray(array, low, mid);
        AreaArray arrayRight = findMaxSubarray(array, mid+1, high);
        
        if(arrayLeft.area > arrayRight.area){
             AreaArray combinedArray = findMaxArea(array, arrayLeft.low, arrayLeft.high, arrayRight.high, arrayLeft.area);
             return combinedArray;
        }else{
            AreaArray combinedArray = findMaxArea(array, arrayLeft.low, arrayLeft.high, arrayRight.high, arrayRight.area);
            return combinedArray;
        }
    }
    
    public static int maxArea(int[] height){
        AreaArray array = findMaxSubarray(height, 0, height.length-1);
        return array.area;
    }

    public static void main(String[] args) {
        /*
        int[] height = new int[150000000];
        
        for(int i = 0; i < 150000000; i++){
            height[i] = height.length-i;
        }
        */
        int[] height = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        
        AreaArray array = findMaxSubarray(height,0, height.length-1);
        
        System.out.println(array.area);
    }

}
