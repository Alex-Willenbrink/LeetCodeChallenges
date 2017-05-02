/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep3v1;

/**
 *
 * @author Alex
 */
public class BNode {

    private char letter;
    private BNode leftnode, rightnode;

    public BNode(char letter) {
        this.letter = letter;
        this.leftnode = null;
        this.rightnode = null;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean addNode(char letter) {

        // First Node adding case
        if (this.letter == letter) {
            return true;
        }

        // Node value greater than current node value
        if (letter > this.letter) {
            if (this.rightnode == null) {
                this.rightnode = new BNode(letter);
                return false;
            } else {
                return this.rightnode.addNode(letter);
            }
        }

        // Node value less than current node value
        // Node value greater than current node value
        if (letter < this.letter) {
            if (this.leftnode == null) {
                this.leftnode = new BNode(letter);
                return false;
            } else {
                return this.leftnode.addNode(letter);
            }
        }

        // Fail safe, something slipped past guard
        return true;
    }

    public void printNodes() {

        if (this == null) {
            return;
        }

        System.out.printf("%c ", this.getLetter());

        if (this.leftnode != null) {
            this.leftnode.printNodes();
        }
        if(this.rightnode!=null){
            this.rightnode.printNodes();
        }
    }
}
