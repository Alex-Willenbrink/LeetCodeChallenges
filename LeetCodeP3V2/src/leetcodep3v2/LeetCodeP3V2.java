/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep3v2;

/**
 *
 * @author Alex
 */
public class LeetCodeP3V2 {

    /**
     * @param args the command line arguments
     */
    public static int lengthOfLongestSubstring(String s) {
        HashTableChar table = new HashTableChar();

        int cLoc = 0, cGlo = 0, resetPos = 0;
        char[] str = s.toCharArray();
        CharNode currNode;

        for (int i = 0; i < s.length(); i++) {
            int currChar = (int) str[i]; // Convert current character to ascii value

            currNode = table.getCharNode(currChar);
            if (currNode.getRepeatVal() == 0) {
                currNode.setRepeatVal(1);
                currNode.setPosition(i);
                cLoc++;
                
            } else if (currNode.getRepeatVal() == 1) {
                int resetPosTemp = currNode.getPosition() + 1; // Move the resetPos up to 1 past the repeat character
                currNode.setPosition(i);              
                
                for (int j = resetPos; j < resetPosTemp-1; j++) {
                    int currCharTemp = (int) str[j];
                    currNode = table.getCharNode(currCharTemp);
                    currNode.setRepeatVal(0);
                    cLoc--;
                }
                
                resetPos = resetPosTemp;
            }

            if (cLoc > cGlo) {
                cGlo = cLoc;
            }
        }
        return cGlo;
    }

    public static void main(String[] args) {

        int answer = lengthOfLongestSubstring("tmmzuxt");
        
        System.out.println(answer);
    }

}
