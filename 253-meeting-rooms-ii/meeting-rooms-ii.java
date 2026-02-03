class Solution {
    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, (a,b)->a[0]-b[0]);


    PriorityQueue<Integer> minHeap = new PriorityQueue();
     
     minHeap.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++){

            int[] current = intervals[i];

            if(current[0] >= minHeap.peek()){
                minHeap.poll();
            }

            minHeap.add(current[1]);
        }
      
      return minHeap.size();
    }
}