package Search_in_Rotated_Sorted_Array_33;

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    public int binarySearch(int[] arr,int target,int start,int end){
        if(end-start<1)
            return target==arr[end] ? end : -1;
        int mid=start+((end-start)/2);
        return Math.max(binarySearch(arr,target,start,mid),binarySearch(arr,target,mid+1,end));
    }
}
