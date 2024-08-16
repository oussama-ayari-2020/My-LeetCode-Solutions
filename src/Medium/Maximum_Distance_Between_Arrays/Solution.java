package Medium.Maximum_Distance_Between_Arrays;

import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans=0;
        int curMin=arrays.get(0).get(0);
        int curMax=arrays.get(0).get(arrays.get(0).size()-1);
        int m=arrays.size();
        for(int i=1;i<m;i++){
            List<Integer> arr=arrays.get(i);
            int n=arr.size();
            int newMax=arr.get(n-1);
            int newMin=arr.get(0);
            ans=Math.max(
              ans,
              Math.max(curMax-newMin,newMax-curMin)
            );

            curMax=Math.max(curMax,newMax);
            curMin=Math.min(curMin,newMin);
        }
        return ans;
    }
}
