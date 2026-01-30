class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int max = nums[0];
        int current = nums[0];
        for(int i =1; i < n; i++){
          current = Math.max(nums[i] , current+nums[i]);

          max = Math.max(max, current);
        }

       return max;
    }
}