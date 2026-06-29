class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0], y = target[1], z = target[2];
        boolean hitX = false, hitY = false, hitZ = false;

        for (int[] t : triplets) {
            // 只保留“不会在任何维度超过 target”的合法三元组
            if (t[0] <= x && t[1] <= y && t[2] <= z) {
                if (t[0] == x) hitX = true;
                if (t[1] == y) hitY = true;
                if (t[2] == z) hitZ = true;
            }
        }
        return hitX && hitY && hitZ;
    }
}
