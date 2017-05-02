/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep6v2;

/**
 *
 * @author Alex
 */
public class LeetCodeP6V2 {

    /**
     * @param args the command line arguments
     */
    public static String convert(String text, int nRows){
        
        if(nRows == 1){
            return text;
        }
        
        char[] textChar = text.toCharArray();
        char[] textCharOut = new char[textChar.length];
        int div_1 = 2+2*(nRows-2);
        int count = 0, row = 0, countNextLocal = 0, countNextGlobal = 0;
        
        for(int i = 0; i < textChar.length; i++){
            
            textCharOut[i] = textChar[count];
            
            // Accounting for first and last rows with weird conditions
            if((row == 0) ||(row == nRows-1)){
                count = count + div_1;
            } else{
                count = count + Math.abs(div_1-countNextLocal);
                countNextLocal = Math.abs(div_1-countNextLocal);
            }
            
            
            if(count >= textChar.length){
                    row++;
                    count = row;
                    countNextGlobal = countNextGlobal+2;
                    countNextLocal = countNextGlobal;
            } 
        }
        
        String output = new String(textCharOut);
        return output;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "1234";
        String textOut = convert(text, 4);
        System.out.println(text);
        System.out.println(textOut);
    }
    
}
