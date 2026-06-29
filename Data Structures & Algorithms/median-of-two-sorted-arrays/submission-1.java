class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length >  nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1)/2;
        int lo = 0, hi = m;

        while(lo <= hi){
            int i = lo + (hi - lo) / 2;
            int j = totalLeft - i;

            int aLeft = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int aRight = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int bRight = (j == n) ? Integer.MIN_VALUE : nums2[j];

            if(aLeft <= bRight && bLeft <= aRight){
                if(((m+n) & 1) == 1){
                    return Math.max(aLeft, bLeft);
                }else{
                    int leftMax = Math.max(aLeft, bLeft);
                    int rightMin = Math.min(aRight, bRight);
                    return (double) (leftMax + rightMin) / 2.0;
                }
            }else if(aLeft > bRight){ // A 取多了
                hi = i - 1;
            }else{ // B 取多了 => A 取少了
                lo = i + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}
