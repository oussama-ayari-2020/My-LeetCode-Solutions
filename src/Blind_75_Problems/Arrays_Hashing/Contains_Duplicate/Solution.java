package Blind_75_Problems.Arrays_Hashing.Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniq=new HashSet<>();
        for(int n : nums){
            if(!uniq.add(n))
                return false;
        }
        return true;
    }
}
