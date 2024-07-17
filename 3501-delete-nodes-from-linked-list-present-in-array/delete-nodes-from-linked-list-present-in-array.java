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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;

        Set<Integer> set = new HashSet<>();
        for (int val: nums) {
            set.add(val);
        }

        ListNode curr = result;
        while (curr.next != null) {
           if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return result.next;
    }
}