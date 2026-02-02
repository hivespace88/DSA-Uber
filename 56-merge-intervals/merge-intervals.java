class Solution {
    public int[][] merge(int[][] intervals) {
     
      Arrays.sort(intervals, (a,b)->a[0]-b[0]);

      List<int[]> result = new ArrayList();
      int[] last = intervals[0];
      result.add(last);

        
        for(int i =1 ; i<intervals.length; i++){
                
            int[] current = intervals[i];
                
            if(current[0] <= last[1]){
                last[1] = Math.max(last[1], current[1]);
            }else{
                last = current;
                result.add(current);
            }
            
        }

        return result.toArray(new int[result.size()][]);
    }
}