class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // 1. 统计频率
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }

        // 2. 最大堆（按剩余次数）
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : cnt) {
            if (x > 0) pq.offer(x);
        }

        int time = 0;

        // 3. 每一轮处理 n + 1 个任务
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Integer> temp = new ArrayList<>();

            while (k > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur - 1 > 0) {
                    temp.add(cur - 1);
                }
                time++;
                k--;
            }

            // 4. 把没做完的任务放回堆
            for (int x : temp) {
                pq.offer(x);
            }

            // 5. 如果这一轮没满 n+1，但后面还有任务 → 补 idle
            if (!pq.isEmpty()) {
                time += k;
            }
        }

        return time;
    }
}
