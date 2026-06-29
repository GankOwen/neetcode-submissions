class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;   // 按位异或
        }
        return res;
    }
}
