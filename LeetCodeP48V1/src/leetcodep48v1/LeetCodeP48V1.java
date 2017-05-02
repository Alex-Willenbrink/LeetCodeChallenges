/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep48v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP48V1 {

    public static void rotate(int[][] matrix){
        int[][] matrixTemp = new int[matrix.length][matrix.length];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrixTemp[j][Math.abs(i - (matrix.length-1))] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = matrixTemp[i][j];
            }
        }
    }
    
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1,2};
        matrix[1] = new int[]{3,4};
        
        
        printMatrix(matrix);
        
        rotate(matrix);
        System.out.println();
        
        printMatrix(matrix);
    }
    
}
