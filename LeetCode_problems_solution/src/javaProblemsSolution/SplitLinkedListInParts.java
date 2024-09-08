package javaProblemsSolution;

public class SplitLinkedListInParts {
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
//        public ListNode[] splitListToParts(ListNode head, int k) {
//            int size = 0;
//            ListNode current = head;
//            while (current != null) {
//                size++;
//                current = current.next;
//            }
//            int subArrLength = size/k;
//            int numRemainingParts = size % k;
//            ListNode[] outPut = new ListNode[k];
//
//            current = head;
//            ListNode prev = current;
//            for (int i = 0; i < k; i++) {
//                // create the i-th part
//                ListNode newPart = current;
//                // calculate size of i-th part
//                int currentSize = subArrLength;
//                if (numRemainingParts > 0) {
//                    numRemainingParts--;
//                    currentSize++;
//                }
//
//                // traverse to end of new part
//                int j = 0;
//                while (j < currentSize) {
//                    prev = current;
//                    current = current.next;
//                    j++;
//                }
//                // cut off the rest of linked list
//                if (prev != null) {
//                    prev.next = null;
//                }
//
//                outPut[i] = newPart;
//            }
//
//            return outPut;
//        }
    }

