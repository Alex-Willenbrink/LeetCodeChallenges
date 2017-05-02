/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep49v2;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class HashCharMap {

    private HashChar[] hashList;

    public HashCharMap(String str) {
        // Make space in the hashmap
        this.hashList = new HashChar[str.length()];

        // Insert values into hashmap
        for (int i = 0; i < str.length(); i++) {
            boolean insertStatus = false;
            char characterInsert = str.charAt(i);
            int insIndex = Character.getNumericValue(characterInsert) % str.length();

            while (!insertStatus) {
                // Create new HashChar
                if (this.hashList[insIndex] == null) {
                    HashChar hashCharNew = new HashChar(characterInsert);
                    this.hashList[insIndex] = hashCharNew;
                    insertStatus = true;
                } else if (this.hashList[insIndex].character == characterInsert) {
                    this.hashList[insIndex].incrementFrequency();
                    insertStatus = true;
                } else {
                    insIndex = (insIndex + 1) % str.length();
                }
            }
        }
    }

    public void printHashMap() {
        for (int i = 0; i < hashList.length; i++) {
            if (hashList[i] != null) {
                System.out.printf("Char: %c, Frequency: %d\n", hashList[i].character, hashList[i].frequency);
            }
        }
    }
    

    public boolean searchMatch(String strTry) {
        if(strTry.length() != this.hashList.length) return false;
        // Make sure you reset all the count frequencies before you leave
        // Make an index list to reset all counts
        ArrayList<Integer> resetList = new ArrayList<>();

        for (int i = 0; i < strTry.length(); i++) {
            boolean foundStatus = false;
            char characterSearch = strTry.charAt(i);
            int searchIndex = Character.getNumericValue(characterSearch) % strTry.length(), count = 0;

            while (!foundStatus && strTry.length() > count) {
                // Nothing there, we've made a terrible mistake
                if (this.hashList[searchIndex] == null) {
                    resetHashChars(resetList);
                    return false;
                } else if (this.hashList[searchIndex].character == characterSearch) {
                    if (this.hashList[searchIndex].frequency > this.hashList[searchIndex].count) {
                        this.hashList[searchIndex].incrementCount();
                        
                        //System.out.printf("Character: %c, Count: %d\n",this.hashList[searchIndex].character ,this.hashList[searchIndex].count);
                        resetList.add(searchIndex);
                        foundStatus = true;
                    } else {
                        resetHashChars(resetList);
                        return false;
                    }
                } else {
                    searchIndex = (searchIndex + 1) % strTry.length();
                    count++;
                }
            }

            // Make sure we found the character 
            if (!foundStatus) {
                resetHashChars(resetList);
                return false;
            }
        }
        
        resetHashChars(resetList);
        return true;
    }
    
    private void resetHashChars(ArrayList<Integer> resetList){
        for(Integer index : resetList){
            this.hashList[index].setCount(0);
        }
    }
}
