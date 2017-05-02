/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep6v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP6V1 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
    
        String string = "PAHNAPLSIIGYIR";
        
        Solution sol = new Solution(string, 3);
        
        Node[] ans = sol.mergeSort(sol.nodes);
        
    }
}
