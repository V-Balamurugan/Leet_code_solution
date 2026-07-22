/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b= a%b;
            a=temp;
        }
        return a;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        for (ListNode temp = head; temp.next != null; ) {

            int g = gcd(temp.val, temp.next.val);

            ListNode newNode = new ListNode(g);

            newNode.next = temp.next;
            temp.next = newNode;

            // Move to original next node
            temp = newNode.next;
        }

        return head;
    
    }
}
