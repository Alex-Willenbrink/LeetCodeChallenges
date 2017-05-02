/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep3v1;

/**
 *
 * @author Alex
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int cLoc, cGlo = 0;
        char[] str = s.toCharArray();
        BNode node = null;

        for (int i = 0; i < s.length(); i++) {
            if(cGlo >= (s.length()-i)){
                return cGlo;
            } // Theoretical case for stopping
            
            cLoc = 0;
            node = null;
            for (int j = i; j < s.length(); j++) {
                
                if(cGlo >= (cLoc+(s.length()-j))){    
                    break;
                }
                
                if (node == null) {
                    node = new BNode(str[j]);
                    cLoc = 1; // Reset Local count
                    if (cLoc > cGlo) {
                        cGlo = cLoc; // Change global count if less than local
                    }
                } else {
                    boolean inTree = node.addNode(str[j]);
                    if (!inTree) {
                        cLoc++;
                        if (cLoc > cGlo) {
                            cGlo = cLoc; // Change global count if less than local
                        }
                    } else {
                        break;
                        //cLoc = 1; // Reset Local count
                        //node = new BNode(str[j]);
                    }
                }
            }
        }
        return cGlo;
    }

}
