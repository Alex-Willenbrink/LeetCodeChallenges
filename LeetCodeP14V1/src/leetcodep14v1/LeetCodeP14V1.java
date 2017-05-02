/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep14v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP14V1 {

    
    public static String longestCommonPrefix(String[] strs){
        // Makes sure there's something in the array
        if(strs.length == 1) return strs[0];
        
        // Now we construct the linked list
        CharList start = new CharList(strs[0]), node = start;
        
        for(int i = 1; i < strs.length; i++){
            node.next = new CharList(strs[i]);
            node = node.next;
        }
        
        // Let's find that prefix one letter in the linked list at at time
        int count = 0;
        while(true){
            node = start;
            for(int i = 0; i < strs.length; i++){
            // Makes sure there is enough length 
                if(node.arrayChar.length < count + 1){
                    return new String(start.arrayChar, 0, count);
                }else if(start.arrayChar[count] != node.arrayChar[count]){
                    return new String(start.arrayChar, 0, count);
                }

                node = node.next; // Proceed to next node
                
            }
            count++;
        }
    }
    
    
    public static void main(String[] args) {
        String[] strs = new String[]{"18", "189", "183",""};
        System.out.println(longestCommonPrefix(strs));
    }
    
}
