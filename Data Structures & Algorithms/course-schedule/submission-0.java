class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int taken = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            taken++;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.offer(v);
            }
        }
        return taken == numCourses;
    }
}
