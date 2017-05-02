/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep36v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP36V1 {

    public static boolean isValidSudoku(char[][] board){
        
        // Makes sure board is of correct size dimensions
        if((board.length != 9) || (board[0].length != 9)) return false;
        
        // Look at each row individually first
        for(int i = 0; i < board.length; i++){
            SHashTable table = new SHashTable();
            for(int j = 0; j < board[i].length; j++){
                if(!table.checkTable(board[i][j])) return false;
            }
        }
        
        
        // Look at column next
        for(int i = 0; i < board.length; i++){
            SHashTable table = new SHashTable();
            for(int j = 0; j < board[i].length; j++){
                if(!table.checkTable(board[j][i])) return false;
            }
        }
        
        
        // Look at each block of the sudoku puzzle
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                SHashTable table = new SHashTable();
                for(int k = i*3; k < (i+1)*3; k++){
                    for(int m = j*3; m < (j+1)*3; m++){
                        if(!table.checkTable(board[k][m])) return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public static void insertString(char[][] board, String str, int line){
        char[] chars = str.toCharArray();
        
        for(int i = 0; i < str.length(); i++){
            board[line][i] = chars[i];
        }
    }

    public static void main(String[] args) {
        
        // make board first
        char[][] board = new char[9][9];
        insertString(board, ".87654321", 0);
        insertString(board, "2........", 1);
        insertString(board, "3........", 2);
        insertString(board, "4........", 3);
        insertString(board, "5........", 4);
        insertString(board, "6........", 5);
        insertString(board, "7........", 6);
        insertString(board, "8........", 7);
        insertString(board, "9........", 8);
        
        SHashTable table = new SHashTable();

        System.out.println(isValidSudoku(board));
        
        
    }
    
}
