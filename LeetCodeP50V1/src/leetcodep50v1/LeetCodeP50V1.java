/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep50v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP50V1 {

    public static double myPow(double x, int n) {
        // Weird zero case
        if (n == 0) {
            return 1;
        }

        double result, type;
        // Check to see if n is odd or even
        if (n % 2 == 0 || x > 0) {
            type = 1;
        } else {
            type = -1;
        }

        if (n > 0) {
            result = x;
        } else {
            result = 1 / x;
        }

        if (n > 0) {
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                result = result * x;
                if (result == 0 || result == 1) {
                    if (result == 0) {
                        return result;
                    }
                    if (result == 1) {
                        return type;
                    }
                }
            }
        } else {
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                result = result * (1 / x);
                if (result == 0 || result == 1) {
                    if (result == 0) {
                        return result;
                    }
                    if (result == 1) {
                        return type;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001, 2147483647));
    }

}
