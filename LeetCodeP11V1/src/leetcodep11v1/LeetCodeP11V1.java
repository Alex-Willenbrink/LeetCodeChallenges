/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep11v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP11V1 {

    public static int maxArea(int[] height){
        int areaGlo = 0, areaLoc = 0;
        
        for(int i = 0; i < height.length-1; i++){
            for(int j = height.length-1; j > i; j--){
                // make sure we aren't wasting our time
                if(areaGlo > height[i]*(j-i)) break; // represents maximum area
                
                if(height[i] < height[j]){
                    areaLoc = height[i]*(j-i);
                } else{
                    areaLoc = height[j]*(j-i);
                }
                if(areaLoc > areaGlo){
                    areaGlo = areaLoc;
                }        
            }
        }
        
        return areaGlo;
    }
    
    public static void main(String[] args) {
        int[] height = new int[150000000];
        
        for(int i = 0; i < 150000000; i++){
            height[i] = height.length-i;
        }
        
        System.out.println(maxArea(height));
        
        
    }
    
}
