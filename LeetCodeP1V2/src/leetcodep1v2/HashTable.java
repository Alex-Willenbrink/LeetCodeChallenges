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
public class HashTable {

    HashValue[] hashValues;
    int hashTableLength;

    public HashTable(int hashTableLength) {
        hashValues = new HashValue[hashTableLength];
        this.hashTableLength = hashTableLength;
        
        for(int i = 0; i < hashTableLength; i++){
            hashValues[i] = new HashValue();
        }
    }

    public void insertHashValue(int value, int index) {
        int tempValue = value;

        for (int i = 0; i < hashTableLength; i++) {
            int hashIndex = Math.abs(tempValue) % hashTableLength;
            if (hashValues[hashIndex].getValue() == null) {
                hashValues[hashIndex].setValue(value);
                hashValues[hashIndex].setIndex(index);
                return;
            } else {
                tempValue++;
            }
        }
    }
    
    public Integer findHashValue(int value) {
        int tempValue = value;

        for (int i = 0; i < hashTableLength; i++) {
            int hashIndex = Math.abs(tempValue) % hashTableLength;
            if (hashValues[hashIndex].getValue() == null) {
                return null;
            } else if(hashValues[hashIndex].getValue() == value){
                return hashValues[hashIndex].getIndex();
            } else {
                tempValue++;
            }
        }
        return null;
    }
}
