class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if(A.length > B.length){
            int[] temp = A; A = B; B = temp;
        }

        int m = A.length, n = B.length;
        int half = (m+n+1)/2;
        int lo = 0, hi = m;
        while(lo <= hi){
            int i = lo + (hi - lo)/2;
            int j = half - i;
            int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];
            int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            if(Aleft <= Bright && Bleft <= Aright){
                if (((m + n) & 1) == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    int leftMax = Math.max(Aleft, Bleft);
                    int rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                }
            }else if (Aleft > Bright) { // A 取多了
                hi = i - 1;
            } else {                     // B 取多了 => A 取少了
                lo = i + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}
