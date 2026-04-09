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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;

        return devideNconquer(lists, 0 , lists.length-1);
    }

    public ListNode  devideNconquer(ListNode[] lists, int start , int end){
          
          if(start == end) return lists[start];
          int mid =  start + (end - start)/2;

          ListNode left =  devideNconquer(lists, start , mid);
          ListNode right = devideNconquer(lists, mid+1 , end );

         return mergeLists(lists, left ,right); 
    }

    public ListNode mergeLists(ListNode[] lists, ListNode l1 , ListNode l2){
           ListNode dummy = new ListNode(0);
           ListNode curr = dummy;  

           while ( l1 != null & l2 != null){
              
              if(l1.val <= l2.val){
                curr.next =l1;
                l1 = l1.next;
               }else{
                curr.next = l2;
                l2  = l2.next;
               } 

               curr  =  curr.next;

              
           }   
           curr.next = l1 != null ? l1 : l2 ; 
         return dummy.next;
    }
}