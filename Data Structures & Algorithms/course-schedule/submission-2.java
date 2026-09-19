class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        int[] state = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            g.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            int course = preq[0];
            int preCourse = preq[1];
            g.get(preCourse).add(course);
        }
        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(hasCycle(i, state, g)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasCycle(int curCourse, int[] state, List<List<Integer>> g){
        if(state[curCourse] == 2) return false;
        if(state[curCourse] == 1) return true;
        state[curCourse] = 1;
        for(int nextCourse : g.get(curCourse)){
            if(hasCycle(nextCourse, state, g)){
                return true;
            }
        }
        state[curCourse] = 2;
        return false;
    }
}
