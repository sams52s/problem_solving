[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem involves merging two sorted linked lists into a single sorted linked list. A straightforward approach could be to collect all the nodes from both lists into a collection, sort the collection based on node values, and then rebuild a new sorted linked list.

# Approach
<!-- Describe your approach to solving the problem. -->
Collect All Nodes:

Traverse both linked lists (list1 and list2), and store all nodes in a List (an ArrayList in this case). This allows easy access to all nodes for further processing.
Sort the Nodes:

Once all nodes are collected, sort the list based on node values using Collections.sort(). The sorting is done using a lambda expression that compares the val of each node.
Rebuild the Linked List:

Create a dummy node to serve as the starting point of the new merged linked list.
Iterate through the sorted list of nodes, linking each node sequentially to form the new merged list.
Ensure that the last node points to null to properly terminate the linked list.
Return the Result:

Return the merged linked list starting from dummy.next, as dummy was just a placeholder.
# Complexity
Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Collecting Nodes: We traverse both linked lists to collect nodes, which takes 𝑂(𝑛+𝑚)O(n+m), where 𝑛 n and 𝑚 m are the lengths of list1 and list2, respectively.
Sorting: Sorting the collected nodes using Collections.sort() takes 𝑂((𝑛+𝑚)log⁡(𝑛+𝑚))O((n+m)log(n+m)).Rebuilding the List: Rebuilding the linked list takes 𝑂(𝑛+𝑚) O(n+m) as we simply iterate through the sorted list.
Overall Time Complexity: The most time-consuming step is sorting, so the overall time complexity is 𝑂((𝑛+𝑚)log(𝑛+𝑚)) O((n+m)log(n+m)).
Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Additional Space: We use a list to store all nodes, which requires 𝑂(𝑛+𝑚) O(n+m) space.
In-place Operations: The sorting and rebuilding steps do not require additional space proportional to the input size.
Overall Space Complexity: The space complexity is 𝑂(𝑛+𝑚)O(n+m) due to the additional space required to store the nodes.

# Code
```java []
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       List<ListNode> nodes = new ArrayList<>();
        while (list1 != null) {
            nodes.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            nodes.add(list2);
            list2 = list2.next;
        }
        Collections.sort(nodes, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (ListNode node : nodes) {
            current.next = node;
            current = current.next;
        }
        current.next = null;
        
        return dummy.next;
    }
}
```
