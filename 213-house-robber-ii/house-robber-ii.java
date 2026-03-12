class Solution {
    public int rob(int[] nums) {
       

       if(nums.length == 1){
        return nums[0];
       }
       int[] seq1 = new int[nums.length-1];
       int[] seq2 = new int[nums.length-1];

       for(int i = 0 ; i<nums.length-1; i++){
        seq1[i] = nums[i];
        seq2[i] = nums[i+1];
       }

       int maxloot1 = robHelper(seq1);
       int maxloot2 = robHelper(seq2);

       return Math.max(maxloot1, maxloot2);
    }

    private int robHelper(int[] nums){
       int maxTillPreviousHouse = 0;
       int maxTillHouseTwoBack = 0;

       for(int num : nums){
         int currentmax = Math.max(maxTillPreviousHouse, maxTillHouseTwoBack+num);
         maxTillHouseTwoBack = maxTillPreviousHouse;
         maxTillPreviousHouse = currentmax;
       }

       return maxTillPreviousHouse;
    }
}