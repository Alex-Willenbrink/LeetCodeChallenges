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
public class HashTableChar {

    private CharNode[] table;

    public HashTableChar() {
        table = new CharNode[128];

        for (int i = 0; i < 128; i++) {
            table[i] = new CharNode();
        }

    }

    public CharNode getCharNode(int location) {
        return table[location];
    }

}
