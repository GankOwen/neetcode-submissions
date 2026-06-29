class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][]cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleet = 0;
        double slowest = -1.0;
        for(int j = 0; j < n; j++){
            double time = (double) (target -cars[j][0]) / cars[j][1];
            if(time > slowest){
                slowest = time;
                fleet++;
            }
        }
        return fleet;
    }
}
