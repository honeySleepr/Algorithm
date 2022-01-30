public class MergeTwoSortedLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode main;
            ListNode head;
            ListNode A = list1;
            ListNode B = list2;

            if (B == null) {
                return A;
            }
            if (A == null) {
                return B;
            }

            if (list2.val <= list1.val) {
                head = list2;
                main = list2;
                B = list2.next;
            } else {
                head = list1;
                main = list1;
                A = list1.next;
            }

            while (A != null && B != null) {
                if (A.val <= B.val) {
                    main.next = A;
                    A = A.next;
                } else {
                    main.next = B;
                    B = B.next;
                }
                main = main.next;
            }

            if (A == null) {
                main.next = B;
            } else {
                main.next = A;
            }

            return head;
        }
    }

    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}
