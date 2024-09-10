package javaProblemsSolution;

public class GreatestCommonDivisors {
//    public ListNode insertGreatestCommonDivisors(ListNode head) {
//        if (head.next == null) return head;
//        ListNode node1 = head;
//        ListNode node2 = head.next;
//        while (node2 != null) {
//            int cd = countDivisors(node1.val, node2.val);
//            ListNode divisorNode = new ListNode(cd);
//            node1.next = divisorNode;
//            divisorNode.next = node2;
//            node1 = node2;
//            node2 = node2.next;
//        }
//
//
//        return head;
//    }

    public int countDivisors(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
