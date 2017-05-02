/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep49v1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> stringsOutput = new ArrayList<List<String>>();
        List<HashCharMap> hashCharMapList = new ArrayList<HashCharMap>();

        // Set up first HashCharMap and add to output list
        hashCharMapList.add(new HashCharMap(strs[0]));
        List<String> strList = new ArrayList<String>();
        strList.add(strs[0]);
        stringsOutput.add(strList);

        // For loop to do other strings
        for (int i = 1; i < strs.length; i++) {
            boolean foundStatus = false;
            for (int j = 0; j < hashCharMapList.size(); j++) {
                // if we find a searchMatch
                if (hashCharMapList.get(j).searchMatch(strs[i])) {
                    // add to output
                    stringsOutput.get(j).add(strs[i]);
                    foundStatus = true;
                    break;
                }
            }
            if (!foundStatus) {
                // Make new hashmap
                hashCharMapList.add(new HashCharMap(strs[i]));

                // Make new list at new index
                stringsOutput.add(new ArrayList<String>());
                stringsOutput.get(stringsOutput.size() - 1).add(strs[i]);
            }
        }
        return stringsOutput;
    }
}

