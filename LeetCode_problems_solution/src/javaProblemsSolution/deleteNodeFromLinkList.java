package javaProblemsSolution;

import java.util.HashSet;

public class deleteNodeFromLinkList {

//        public ListNode modifiedList(int[] nums, ListNode head) {
//            HashSet<Integer> numSet = new HashSet<>();
//            for(var num : nums)numSet.add(num);
//            ListNode dummyHead = new ListNode();
//            dummyHead.next = head;
//            ListNode curr = dummyHead, prev = dummyHead;
//            while(curr != null){
//                ListNode nextNode = curr.next;
//                if(numSet.contains(curr.val)){
//                    prev.next = nextNode;
//                }else{
//                    prev = curr;
//                }
//                curr = nextNode;
//            }
//            return dummyHead.next;
//        }


    //! `ANOTHER SOLUTION`
//    public ListNode modifiedList(int[] nums, ListNode head) {
//        ListNode prev = null;
//        ListNode ptr = head;
//        HashSet<Integer> set = new HashSet<>();
//        for(int i:nums)
//        {
//            set.add(i);
//        }
//        while(ptr!=null)
//        {
//            if(set.contains(ptr.val))
//            {
//                if(ptr==head)
//                {
//                    head=ptr.next;
//                }
//                else
//                {
//                    prev.next = ptr.next;
//                }
//            }
//            else
//            {
//                prev = ptr;
//            }
//            ptr=ptr.next;
//        }
//        return head;
//    }
    }
