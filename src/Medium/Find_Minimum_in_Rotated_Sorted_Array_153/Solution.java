package Medium.Find_Minimum_in_Rotated_Sorted_Array_153;

class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums,0, nums.length-1);
    }

    public int binarySearch(int[] nums,int start,int end){
        if(end-start<1)
            return nums[end];
        int mid=start+((end-start)/2);
        return Math.min(binarySearch(nums,start,mid),binarySearch(nums,mid+1,end));
    }
}