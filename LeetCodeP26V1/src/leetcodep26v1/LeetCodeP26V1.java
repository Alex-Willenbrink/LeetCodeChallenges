/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep26v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP26V1 {

    /**
     * @param args the command line arguments
     */
    public static int removeDuplicates(int[] nums) {

        int numCur = nums[0];
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (numCur != nums[i]) {
                numCur = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        int[] num = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 7, 7, 7, 7};
        int points = removeDuplicates(num);
        System.out.println(points);

        for (int i = 0; i < num.length; i++) {
            System.out.printf("%d ", num[i]);
        }
        System.out.println();
    }

}
