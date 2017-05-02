package leetcodep6v1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Node {
    private char character;
    private int[] position;
    
    public Node(char character, int[] position){
        this.character = character;
        this.position = position;
    }
    
    public char getChar(){
        return character;
    }
    
    public int[] getPos(){
        return position;
    }
    
    public void setPos(int[] position){
        this.position = position;
    }
    
    public void setChar(char character){
        this.character = character;
    }
    
}
