package Blind_75_Problems.Arrays_Hashing.Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> occ=new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(occ.containsKey(target-nums[i]))
                return new int[]{i,occ.get(target-nums[i])};
            else occ.put(nums[i],i);
        }
        return new int[]{};
    }
}
