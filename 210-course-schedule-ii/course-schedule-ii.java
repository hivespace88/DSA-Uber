class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;

        List<List<Integer>> graph = new ArrayList();

        for(int i =0 ; i<n ; i++){
            graph.add(new ArrayList());
        }

       int[] indegree = new int[n];
        for(int[] p : prerequisites){
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList();

        for(int i =0 ; i<n ; i++){
            
            if(indegree[i]  == 0){
                q.offer(i);
            }
        }

        int[] result = new int[n];
        int index = 0;


       while(!q.isEmpty()){
        int node =  q.poll();
        result[index++] = node;

        for(int neigbhour : graph.get(node)){
            indegree[neigbhour]--;
            if(indegree[neigbhour] == 0){
                q.offer(neigbhour);
            }
        }

       }

       if(index == n){
        return result;
       }
     return new int[0];
    }
}