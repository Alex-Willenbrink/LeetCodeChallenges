/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep29v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP29V1 {

    public static int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }else if((divisor == -1) && (dividend == Integer.MIN_VALUE)){
            return Integer.MAX_VALUE;
        }else if ((divisor == 1) && (dividend == Integer.MIN_VALUE)){
            return Integer.MAX_VALUE;
        }
        
        long dividendLong = dividend;
        long divisorLong = divisor;
        int count = 0;

        if ((dividendLong > 0) && (divisorLong > 0)) {
            while ((dividendLong = dividendLong - divisorLong) >= 0) {
                count++;
            }
            return count;
        } else if ((dividendLong < 0) && (divisorLong < 0)) {
            while ((dividendLong = dividendLong - divisorLong) <= 0) {
                count++;
            }
            return count;
        } else if ((dividendLong > 0) && (divisorLong < 0)) {
            while ((dividendLong = dividendLong + divisorLong) >= 0) {
                count--;
            }
            return count;
        } else if ((dividendLong < 0) && (divisorLong > 0)) {
            while ((dividendLong = dividendLong + divisorLong) <= 0) {
                count--;
            }
            return count;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
    }

}
