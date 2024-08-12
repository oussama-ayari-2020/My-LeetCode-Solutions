package Design_A_Class.Easy;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(this.minHeap.size()<this.k)
            this.minHeap.offer(val);
        else if(this.minHeap.peek()<val){
            this.minHeap.poll();
            this.minHeap.add(val);
        }
        return this.minHeap.peek();
    }
}