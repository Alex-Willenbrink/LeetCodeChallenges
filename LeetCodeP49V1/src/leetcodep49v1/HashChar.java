/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep49v1;

/**
 *
 * @author Alex
 */
public class HashChar {

    char character;
    int frequency = 1;
    int count = 0;

    public HashChar(char character) {
        this.character = character;
    }

    public void incrementFrequency() {
        this.frequency++;
    }

    public void incrementCount() {
        this.count++;
    }

    public void setCount(int count) {
        this.count = count;
    }
}