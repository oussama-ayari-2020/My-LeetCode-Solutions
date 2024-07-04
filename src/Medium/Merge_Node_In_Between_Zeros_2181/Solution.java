package Medium.Merge_Node_In_Between_Zeros_2181;

import Custom_Data_Structures.ListNode;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode res=new ListNode(-1,null);
        ListNode resIt=res;
        int sum=0;
        ListNode it=head.next;
        while(it!=null){
            if(it.val!=0){
                sum+=it.val;
                it=it.next;
            }else{
                ListNode node=new ListNode(sum,null);
                resIt.next=node;
                resIt=node;
                it=it.next;
                sum=0;
            }
        }
        return res.next;
    }
}
