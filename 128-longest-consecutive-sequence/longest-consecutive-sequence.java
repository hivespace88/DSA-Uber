class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        
        int maxStreak =0;
        for(int num : set){

            if(!set.contains(num-1)){
                int currentStreak = 1;
                int currentnum = num;

                 while(set.contains(currentnum+1)){
                    currentnum++;
                    currentStreak++;
                 }
                 maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }
}