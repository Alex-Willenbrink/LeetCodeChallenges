/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep6v1;

/**
 *
 * @author Alex
 */
public class Solution {

    public Node[] nodes;
    private String string;
    private char[] stringchar;
    public static int count;
    public int length;

    public Solution(String string, int numRows) {
        nodes = new Node[string.length()];
        this.string = string;
        stringchar = string.toCharArray();
        makeNodes(numRows);
        this.length = stringchar.length;
    }

    public void setNode(char character, int[] position, int nodeNum) {
        nodes[nodeNum] = new Node(character, position);
    }

    private void makeNodes(int numRows) {
        int countR = 0, countC = 0, dirR = 0, dirC = 0;

        for (int i = 0; i < string.length(); i++) {
            
            // Find new counts for setting up next character
            countR = countR + dirR;
            countC = countC + dirC;
            
            //System.out.printf("Row: %d, Column: %d\n", countR, countC);
            
            this.setNode(stringchar[i], new int[]{countR, countC}, i);
            
            // Condition 1 for Row (Heading down)
            if(countR == 0){
                dirC = 0;
                dirR = 1;
            }
            
            // Condition 2 for Row
            if(countR == numRows-1){
                dirC = 1;
                dirR = -1;
            }
            
            // Makes sure not weird case of 1 Row in place
            if(numRows == 1){
                dirC = 1;
                dirR = 0;
            }
        }
    }
        
     public Node[] mergeSort(Node[] array){
        if (array.length == 1){
            return array;
        }
        
        Node[] a_1 = arrayCopy(array, 0, array.length/2-1);
        
        Node[] a_2 = arrayCopy(array, array.length/2, array.length-1);
        
        a_1 = mergeSort(a_1);
        a_2 = mergeSort(a_2);
        
        Node[] a_3 = merge(a_1, a_2);
        
        return a_3;
    }
    
    public Node[] merge(Node[] a_1, Node[] a_2){
        
        int ind_1=0, ind_2=0, ind_3=0;
        Node[] a_3 = new Node[a_1.length+a_2.length];
        
        while((ind_1<a_1.length) && (ind_2<a_2.length)){
            int[] pos_1 = a_1[ind_1].getPos();
            int[] pos_2 = a_2[ind_2].getPos();
            
            if(pos_1[0] < pos_2[0]){
                a_3[ind_3].setPos(a_1[ind_1].getPos());
                a_3[ind_3].setChar(a_1[ind_1].getChar());
                ind_1++;
                ind_3++;
            }else if (pos_1[0] > pos_2[0]){
                a_3[ind_3].setPos(a_2[ind_2].getPos());
                a_3[ind_3].setChar(a_2[ind_2].getChar());
                ind_2++;
                ind_3++;
            }else{
                if(pos_1[1] < pos_2[1]){
                    a_3[ind_3].setPos(a_1[ind_1].getPos());
                    a_3[ind_3].setChar(a_1[ind_1].getChar());
                    ind_1++;
                    ind_3++;
                }else{
                    a_3[ind_3].setPos(a_2[ind_2].getPos());
                    a_3[ind_3].setChar(a_2[ind_2].getChar());
                    ind_2++;
                    ind_3++;
                }   
            }
        }
        
        while(a_1.length>ind_1){
            a_3[ind_3] = a_1[ind_1];
            ind_1++;
            ind_3++;
        }
        
        while(a_2.length>ind_2){
            a_3[ind_3] = a_2[ind_2];
            ind_2++;
            ind_3++;
        }
        
        return a_3;
    }
    
    public Node[] arrayCopy(Node[] array, int start, int end){
        int e_num = end+1-start;
        Node[] array_out = new Node[e_num];
        
        for(int i = 0; i<e_num; i++){
            array_out[i].setChar(array[start+i].getChar());
            array_out[i].setPos(array[start+i].getPos());
        }
        return array_out;
    }
}
