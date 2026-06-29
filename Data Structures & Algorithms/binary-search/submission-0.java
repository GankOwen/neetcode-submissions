class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left] == target? left : -1;
    }
}
