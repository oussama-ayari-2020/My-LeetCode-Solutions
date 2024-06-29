package Blind_75_Problems.Arrays_Hashing.Top_K_Frequent_Elements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occ=new HashMap<>();
        int[] res=new int[k];
        for(int n:nums)
            occ.put(n,occ.getOrDefault(n,0)+1);
        PriorityQueue<Pair> heap=new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        for(Map.Entry<Integer,Integer> entry:occ.entrySet()) {
            heap.offer(new Pair(entry.getKey(), entry.getValue()));
            if(heap.size()>k)
                heap.poll();
        }
        int i=0;
        while(!heap.isEmpty())
            res[i++]=heap.poll().num;
        return res;
    }

    class Pair{
        int num;
        int frequency;

        public Pair(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "num=" + num +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}

