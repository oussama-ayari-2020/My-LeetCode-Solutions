package Blind_75_Problems.Arrays_Hashing.Valid_Anagram;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] c1=new int[26];
        int[] c2=new int[26];

        for(int i=0;i<s.length();i++){
            c1[s.charAt(i)-'a']++;
            c2[t.charAt(i)-'a']++;
        }
        return Arrays.equals(c1,c2);
    }
}
