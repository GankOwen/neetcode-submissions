class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
            degrees[course]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(degrees[i]==0){
                deque.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while(!deque.isEmpty()){
            int pre = deque.poll();
            List<Integer> courses = graph.get(pre);
            order[index++] = pre;
            for(int course : courses){
                if(--degrees[course] == 0){
                    deque.offer(course);
                }
            }
        }
        if (index != numCourses) return new int[0];
        return order;
    }
}
