/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep5v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP5V1 {

    public static int minValue(int[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[min] >= array[i]) {
                min = i;
            }
        }
        return min;
    }

    public static int[] longestPalindromeMiddle(char[] array, int index) {
        int x = index, y = index;
        int[] space = new int[]{x, array.length - y - 1};

        int whichMin = space[minValue(space)];
        if (whichMin == space[0]) {
            for (int i = whichMin; i > 0; i--) {
                x--;
                y++;
                if (array[x] != array[y]) {
                    x++;
                    y--;
                    break;
                }
            }
        } else {
            // for loop to look for longest palindrome at specific spot
            for (int i = y; i < array.length-1; i++) {
                x--;
                y++;

                if (array[x] != array[y]) {
                    x++;
                    y--;
                    break;
                }
            }
        }
        
        return new int[]{x, y};
    }
    
    public static int[] longestPalindromeRight(char[] array, int index) {
        int x = index, y = index+1;
        int[] space = new int[]{x, array.length - y - 1};
        
        // Make sure start off with palindrome
        if(array[x] != array[y]) return new int[]{x, x};
        
        int whichMin = space[minValue(space)];
        if (whichMin == space[0]) {
            for (int i = whichMin; i > 0; i--) {
                x--;
                y++;
                if (array[x] != array[y]) {
                    x++;
                    y--;
                    break;
                }
            }
        } else {
            // for loop to look for longest palindrome at specific spot
            for (int i = y; i < array.length-1; i++) {
                x--;
                y++;

                if (array[x] != array[y]) {
                    x++;
                    y--;
                    break;
                }
            }
        }
        
        return new int[]{x, y};
    }
    
    

    public static String longestPalindrome(String s) {
        char[] sc = s.toCharArray();

        // Case for 0 and other input 
        if (sc.length == 0) {
            return s;
        }
        // Starting parameters
        int count = 0, x = 0, y = 0;
        
        for(int i = 0; i < sc.length; i++){
            int[] indexes = longestPalindromeMiddle(sc, i);
            
            if((indexes[1]-indexes[0]) > count){
                count = indexes[1] - indexes[0];
                x = indexes[0];
                y = indexes[1];
            }
        }
        
        for(int i = 0; i < sc.length-1; i++){
            int[] indexes = longestPalindromeRight(sc, i);
            
            if((indexes[1]-indexes[0]) > count){
                count = indexes[1] - indexes[0];
                x = indexes[0];
                y = indexes[1];
            }
        }
        
        return new String(sc, x, y-x+1);
    }

    public static void main(String[] args) {
        
        System.out.println(longestPalindrome(new String("cbbd")));

    }

}
