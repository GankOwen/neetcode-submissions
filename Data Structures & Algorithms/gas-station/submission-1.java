class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            int remain = gas[i] - cost[i];
            totalSum += remain;
            curSum += remain;
            if(curSum < 0){
                start = i+1;
                curSum = 0;
            }
        }
        if(totalSum < 0) return -1;
        return start;
    }
}
