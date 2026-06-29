class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());

        int[] indeg = new int[numCourses];
        for (int[] e : prerequisites) {
            int a = e[0], b = e[1]; // b -> a
            g.get(b).add(a);
            indeg[a]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.offer(v);
            }
        }

        // 若课程未全部加入，说明有环
        if (idx != numCourses) return new int[0];
        return order;
    }
}
