package Blind_75_Problems.Arrays_Hashing.Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        Set<Integer> uniq=new HashSet<>();
        for(int num : nums)
            uniq.add(num);
        for(int n : uniq){
            if(!uniq.contains(n-1)){
                int count=1;
                while(uniq.contains(n+count))
                    count++;
                res=Math.max(res,count);
            }
        }
        return res;
    }
}

