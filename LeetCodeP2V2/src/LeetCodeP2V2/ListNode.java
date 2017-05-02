/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */

package LeetCodeP2V2;

public class ListNode {
    int val;
    ListNode next;
    
    
    // ListNode (int x) { val = x; }, another way of making constructor
    
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    
    public ListNode(int val, ListNode next ){
        this.val = val;
        this.next = next;
    }
    
    public ListNode(ListNode copy){
        this.next = copy.next;
        this.val = copy.val;
    }
    
    public void printVal(){
        System.out.printf("%d ", this.val);
    }
    
}
