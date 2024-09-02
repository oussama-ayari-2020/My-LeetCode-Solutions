package Blind_75_Problems.Heap_Priority_Queue.Kth_Largest_Element;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap=new PriorityQueue<>(k);
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return  minHeap.peek();
    }
}
