/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep3v2;

/**
 *
 * @author Alex
 */
public class CharNode {
    
    private int repeatVal;
    private int position;
    
    public CharNode(){
        this.repeatVal = 0;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public void setRepeatVal(int repeatval){
        this.repeatVal = repeatval;
    }
    
    public int getPosition(){
        return position;
    }
    
    public int getRepeatVal(){
        return repeatVal;
    }
    
}
