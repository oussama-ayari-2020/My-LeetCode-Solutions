package Medium.Remove_Nth_Node_From_End_of_List_19;

import Custom_Data_Structures.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode it=head;
        while(it!=null){
            it=it.next;
            len++;
        }
        if(len>1){
            int target=len-n;
            it=head;
            if(target==0){
                return it.next;
            }else{
                for(int i=0;i<target-1;i++)
                    it=it.next;
                ListNode del=it.next;
                if(del.next==null){
                    it.next=null;
                }else{
                    it.next=del.next;
                    del.next=null;
                }
            }

        }else return null;

        return head;
    }
}
