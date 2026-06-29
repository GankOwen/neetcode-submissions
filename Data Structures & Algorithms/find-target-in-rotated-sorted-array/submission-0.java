class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int p = findPivot(nums); // 最小值下标
        int l, r;
        if (target >= nums[p] && target <= nums[n - 1]) {
            l = p; r = n - 1;
        } else {
            l = 0; r = p - 1;
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m + 1; else r = m - 1;
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return l; // 最小值下标
    }
}
