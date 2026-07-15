class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int completed = 0;
        while(!deque.isEmpty()){
            int prereq = deque.poll();
            completed++;
            List<Integer> courses = graph.get(prereq);
            for(int course : courses){
                degrees[course]--;
                if(degrees[course] == 0){
                    deque.offer(course);
                }
            }
        }
        return completed == numCourses;
    }
}
