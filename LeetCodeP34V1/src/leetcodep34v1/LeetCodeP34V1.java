/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep34v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP34V1 {

    public static int binSearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = (low + high) / 2;

        while (high >= low) {
            if (target < nums[mid]) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else if (target > nums[mid]) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        int low = 0, high = nums.length - 1, mid = (low + high) / 2;

        // Check to make sure that target is possibly within range of numbers and high is above -1
        if ((target > nums[high]) || (target < nums[low]) || (high < 0)) {
            return ans;
        }

        // Find lower bound first
        while (high >= low) {
            if (nums[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else if (nums[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            } else {
                high = mid - 1;
                if (nums[mid] == target) {
                    if(low > high) break;
                    else if (nums[high] != target) break;
                }
                mid = (low + high) / 2;
            }
        }

        if (nums[mid] == target) {
            ans[0] = mid;
        } else {
            return ans;
        }

        high = nums.length - 1;
        mid = (low + high) / 2;

        // Find higher bound second
        while (high >= low) {
            if (nums[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else if (nums[mid] < target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                if (nums[mid] == target) {
                    if(low > high) break;
                    else if (nums[low] != target) break;
                }
                mid = (low + high) / 2;
            }
        }

        ans[1] = mid;
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 88};

        int[] ans = searchRange(nums, 9);
        System.out.printf("num low: %d, num high: %d\n", ans[0], ans[1]);
    }

}
