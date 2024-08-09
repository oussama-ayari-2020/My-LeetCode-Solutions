package Blind_75_Problems.Binary_Search.Koko_Eating_Bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mid;
        int low=1;
        int high=piles[0];
        for(int p : piles) {
            high = Math.max(high, p);
        }
        int res=high;
        while (low<=high){
            mid=low+((high-low)/2);
            int totalTime=0;
            for(int p : piles)
                totalTime+= Math.ceil((double) p /mid);
            if(totalTime<=h){
                res=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return res;
    }
}
