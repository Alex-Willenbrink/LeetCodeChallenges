/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodep21v1;

/**
 *
 * @author Alex
 */
public class LeetCodeP21V1 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Make sure both inputs are initally set at null
        if ((l1 == null) && (l2 == null)) {
            return null;
        }

        ListNode l3 = new ListNode(0);
        ListNode startNode = l3;

        // 1. Case if either l1 or l2 is a null value
        // 2. Case for which value is greater
        if (l2 == null) {
            l3.val = l1.val;
            l1 = l1.next;
        } else if (l1 == null) {
            l3.val = l2.val;
            l2 = l2.next;
        } else if (l2.val > l1.val) {
            l3.val = l1.val;
            l1 = l1.next;
        } else {
            l3.val = l2.val;
            l2 = l2.next;
        }

        while ((l1 != null) && (l2 != null)) {
            if (l2.val > l1.val) {
                l3.next = new ListNode(l1.val);
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = new ListNode(l2.val);
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            l3.next = new ListNode(l1.val);
            l3 = l3.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            l3.next = new ListNode(l2.val);
            l3 = l3.next;
            l2 = l2.next;
        }

        return startNode;
    }

    public static void main(String[] args) {

    }

}
