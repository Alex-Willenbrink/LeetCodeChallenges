/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep29v2;

/**
 *
 * @author Alex
 */
public class LeetCodeP29V2 {

    public static boolean willAdditionOverflow(int left, int right) {
        try {
            Math.addExact(left, right);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }else if((divisor == -1) && (dividend == Integer.MIN_VALUE)){
            return Integer.MAX_VALUE;
        }else if ((divisor == 1) && (dividend == Integer.MIN_VALUE)){
            return Integer.MIN_VALUE;
        } else if((divisor == Integer.MAX_VALUE) && (dividend == Integer.MIN_VALUE)){
            return 0;
        } else if(divisor == Integer.MIN_VALUE && dividend != Integer.MIN_VALUE){
            return 0;
        } 
        
        if((dividend > 0) && (divisor > 0)) return divide1(dividend, divisor);
        if((dividend < 0) && (divisor < 0)) return divide2(dividend, divisor);
        if((dividend > 0) && (divisor < 0)) return divide3(dividend, divisor);
        if((dividend < 0) && (divisor > 0)) return divide4(dividend, divisor);
        
        return 0;
    }
    
    public static int divide1(int dividend, int divisor) {
        // (+) dividend, (+) divisor
        if(dividend < divisor) return 0;
        int countDouble = 1, countDoubleLast = countDouble, divTemp = divisor, divTempLast = divTemp;
        
        while((dividend > divTemp) && !willAdditionOverflow(divTemp, divTemp)){
            
            countDoubleLast = countDouble;
            divTempLast = divTemp;
            countDouble = countDouble + countDouble;
            divTemp = divTemp + divTemp;
        }
                
        return countDoubleLast + divide1(dividend - divTempLast, divisor);
    }
    
    public static int divide2(int dividend, int divisor) {
        // (-) dividend, (-) divisor
        if(dividend > divisor) return 0;
        int countDouble = 1, countDoubleLast = countDouble, divTemp = divisor, divTempLast = divTemp;
        
        while((dividend < divTemp) && !willAdditionOverflow(divTemp, divTemp)){
            countDoubleLast = countDouble;
            divTempLast = divTemp;
            countDouble = countDouble + countDouble;
            divTemp = divTemp + divTemp;
        }
                
        return countDoubleLast + divide2(dividend - divTempLast, divisor);
    }
    
    public static int divide3(int dividend, int divisor) {
        // (+) dividend, (-) divisor
        if(dividend < (0 - divisor)) return 0;
        int countDouble = -1, countDoubleLast = countDouble, divTemp = divisor, divTempLast = divTemp;
        
        while(dividend > (0 - divTemp) && !willAdditionOverflow(divTemp, divTemp)){
            countDoubleLast = countDouble;
            divTempLast = divTemp;
            countDouble = countDouble + countDouble;
            divTemp = divTemp + divTemp;
        }
                
        return countDoubleLast + divide3(dividend + divTempLast, divisor);
    }
    
    public static int divide4(int dividend, int divisor) {
        
        // (-) dividend, (+) divisor
        if((0 - dividend) < divisor && dividend != Integer.MIN_VALUE) return 0;
        int countDouble = -1, countDoubleLast = countDouble, divTemp = divisor, divTempLast = divTemp;
        while((0 - dividend) > divTemp && !willAdditionOverflow(divTemp, divTemp)){
            countDoubleLast = countDouble;
            divTempLast = divTemp;
            countDouble = countDouble + countDouble;
            divTemp = divTemp + divTemp;
        }
                
        return countDoubleLast + divide4(dividend + divTempLast, divisor);
    }
    
    
    public static void main(String[] args) {
        System.out.println(divide(1038925803, -2147483648));
    }
    
}
