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
public class SHashTable {
    private boolean[] table;
    
    public SHashTable(){
        boolean[] table = new boolean[9];
        for(int i = 0; i < 9; i++){
            table[i] = false;
        }
        this.table = table;
    }
    

    public boolean checkTable(char c){
        // Makes sure that character can be converted to numeric and is within range
        if(c == '.') return true;
        int place = Character.getNumericValue(c) - 1;
        if(place < 0 || place > 8) return false;
        
        // Let's see if value exists in table yet
        if(this.table[place]){
            return false;
        } else{
            this.table[place] = true;
            return true;
        }
    }
}

