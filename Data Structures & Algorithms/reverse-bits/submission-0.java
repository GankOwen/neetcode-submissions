class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;        // res 左移一位，腾位置
            res |= (n & 1);  // 把 n 的最低位加进来
            n >>>= 1;        // n 无符号右移一位
        }
        return res;
    }
}
