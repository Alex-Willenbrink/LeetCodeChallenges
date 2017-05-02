/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep12v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP12V1 {
    
    public static String repeatString(String str, int mul){
        String strReturn = "";
        for(int i = 0; i < mul; i++){
            strReturn = strReturn + str;
        }
        return strReturn;
    }
    
    
    public static String intToRoman(int num){        
        int low;
        
        // 1000 'M'
        if((low = num/1000)>0){
            return repeatString("M", low) + intToRoman(num%1000);
        }
        
         // 500 'D'
        if((low = num/500)>0){
            if(num >= 900){
                return "CM" + intToRoman(num-900);
            }else{
                return repeatString("D", low) + intToRoman(num%500);
            }
        }
        
        // 100 'C'
        if((low = num/100)>0){
            if(num >= 400){
                return "CD" + intToRoman(num-400);
            } else {
                return repeatString("C", low) + intToRoman(num%100);
            } 
        }
        
        
        // 50 'L'
        if((low = num/50)>0){
            if(num >= 90){
                return "XC" + intToRoman(num-90);
            }else{
                return repeatString("L", low) + intToRoman(num%50);
            }
        }
        
        // 10 'X'
        if((low = num/10)>0){
            if(num >= 40){
                return "XL" + intToRoman(num-40);
            } else {
                return repeatString("X", low) + intToRoman(num%10);
            } 
        }
        
        // 5 'V'
        if((low = num/5)>0){
            if(num >= 9){
                return "IX" + intToRoman(num-9);
            }else{
                return repeatString("V", low) + intToRoman(num%5);
            }
        }
        
        // 1 'I'
        if((low = num/1)>0){
            if(num >= 4){
                return "IV" + intToRoman(num-4);
            } else {
                return repeatString("I", low);
            }
        }
        
        return "";
    }
    

    public static void main(String[] args) {
        /*
        String a = new String("aaaa");
        String b = new String("bbbb");
        
        String c = repeatString(a, 5) + b;
        
        System.out.println(c);
        
        System.out.println(5%4);
        */
        
        System.out.println(intToRoman(99));
        
        
    }
    
}
