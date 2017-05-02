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

import java.util.Random;

public class Solution {
    public static void main(String[] args){
        
        Random rand = new Random();
        ListNode node1 = null, node2 = null, node3 = null;
        
        // Create Example Nodes
        for(int i=0; i<3; i++){
            node1 = new ListNode(rand.nextInt(10), node1);
            node2 = new ListNode(rand.nextInt(10), node2);
        }
        
        ListNode node1Hold = new ListNode(node1);
        ListNode node2Hold = new ListNode(node2);
                
        int val1, val2, total, carry=0;
        
        while((node1!= null) || (node2!=null) || (carry==1)){
            
            if(node1==null){
                val1=0;
            }else{
                val1=node1.val;
            }
            
            if(node2==null){
                val2=0;
            }else{
                val2=node2.val;
            }
            
            total=val1+val2+carry;
            if(total>9){
                total=total%10;
                carry=1;
            }else{
                carry=0;
            }
            //System.out.println(total);
            
            node3 = new ListNode(total, node3);
            
            if(node1!=null){
                node1=node1.next;
            }
            if(node2!=null){
                node2=node2.next;
            }
            
        }
        
        while(node1Hold != null){
            node1Hold.printVal();
            node1Hold = node1Hold.next; 
        }
        
        System.out.println();
        
        while(node2Hold != null){
            node2Hold.printVal();
            node2Hold = node2Hold.next; 
        }
        
        System.out.println();
        
        
        // Print node3 Values
        while(node3 != null){
            node3.printVal();
            node3 = node3.next; 
        }
        
        System.out.println();
        
    }
    
}
