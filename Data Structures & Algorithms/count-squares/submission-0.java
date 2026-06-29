class CountSquares {
    private Map<Integer, Map<Integer, Integer>> cnt;
    public CountSquares() {
        cnt = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        if(!cnt.containsKey(x)){
            cnt.put(x, new HashMap<>());
        }

        Map<Integer, Integer> map = cnt.get(x);

        if(!map.containsKey(y)){
            map.put(y,1);
        }else{
            map.put(y,map.get(y)+1);
        }
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        if(!cnt.containsKey(x)) return 0;

        int res = 0;
        Map<Integer, Integer> sameX = cnt.get(x); //所有 (x,y2)

        for(Map.Entry<Integer, Integer> entry : sameX.entrySet()){
            int y2 = entry.getKey();
            int c1 = entry.getValue(); // (x,y2)的次数

            // 边长为 0，不构成正方形
            if (y2 == y) continue;

            int d= y2-y; // 可以正负都行，用时注意 x±d

            // 方向一：x + d
            int x1 = x + d;
            res += countSquaresWithOtherX(x, y, y2, x1, c1);

            // 方向二：x - d
            int x2 = x - d;
            res += countSquaresWithOtherX(x, y, y2, x2, c1);
        }

        return res;
    }

    private int countSquaresWithOtherX(int x, int y, int y2, int otherX, int c1){
        Map<Integer, Integer> col = cnt.get(otherX);
        if(col == null) return 0;

        int c2 = col.getOrDefault(y, 0); //(otherX, y)
        int c3 = col.getOrDefault(y2, 0); //(otherX, y2)

        if(c2==0 || c3==0) return 0;
        return c1 * c2 * c3;
    }
}
