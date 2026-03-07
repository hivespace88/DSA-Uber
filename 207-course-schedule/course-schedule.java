class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      List<List<Integer>> graph = new ArrayList();

      for(int i=0; i<numCourses;i++){
        graph.add( new ArrayList());
      }
      int[] indegree = new int[numCourses];
      for(int[] p : prerequisites){
             int course =    p[0];
             int prereq = p[1];

             graph.get(prereq).add(course);
             indegree[course]++; 
      }

      Queue<Integer> q = new LinkedList();

      for(int i = 0 ; i<numCourses; i++){
        if(indegree[i] == 0){
            q.offer(i);
        }
      }
      
      int count = 0;
      while(!q.isEmpty()){
         int node =  q.poll(); 

         count++;

          for(int neigbhour : graph.get(node)){
              indegree[neigbhour]--;

              if(indegree[neigbhour] == 0){
                q.offer(neigbhour);
              }
          }
      }

      return count == numCourses;
    }
}
