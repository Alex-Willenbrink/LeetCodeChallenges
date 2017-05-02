/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep1v2;

/**
 *
 * @author Alex
 */
public class HashValue {
    private Integer value = null, index = null;
    
    public HashValue(){
        value = null;
        index = null;
    }
    
    public HashValue(Integer value, Integer index){
        this.value = value;
        this.index = index;
    }
    
    public Integer getValue(){
        return value;
    } 
    
    public Integer getIndex(){
        return index;
    }
    
    public void setValue(Integer value){
        this.value = value;
    }
    
    public void setIndex(Integer index){
        this.index = index;
    }
    
}
