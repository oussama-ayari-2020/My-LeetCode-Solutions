package Minimum_Number_of_Days_to_Make_m_Bouquets_1482;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=0;
        int end=0;
        for(int day : bloomDay)
            end=Math.max(end,day);
        int ans=0;
        while(start <= end){
            int mid=(start+end)/2;
            if(numberOfBouquets(bloomDay,mid,k)>=m){
                end=mid-1;
                ans=mid;
            }else{
                start=mid+1;
            }
        }
        return ans==0 ? -1 : ans;
    }

    public int numberOfBouquets(int[] bloomDay,int day,int k){
        int count=0;
        int res=0;
        for(int bloom : bloomDay){
            if(bloom<=day)
                count++;
            else count =0;

            if(count==k){
                res++;
                count=0;
            }

        }
        return res;
    }
}