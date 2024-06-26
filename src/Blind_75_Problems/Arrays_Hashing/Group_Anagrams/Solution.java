package Blind_75_Problems.Arrays_Hashing.Group_Anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> occ=new HashMap<>();
        for(String s :strs){
            char[] sign=s.toCharArray();
            Arrays.sort(sign);
            String sorted=new String(sign);
            List<String> l=occ.getOrDefault(sorted,new ArrayList<>());
            l.add(s);
            occ.put(sorted,l);
        }
        return occ.values().stream().toList();
    }
}
