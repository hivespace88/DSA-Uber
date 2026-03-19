class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList(), result);
        return result;
    }

    private void  backtrack(int start, int[] nums, List<Integer> current,List<List<Integer>> result){

        if(result.contains(current)){
            return ;
        }

        result.add(new ArrayList(current));

        for(int i = start ; i <nums.length; i++){
            current.add(nums[i]);

            backtrack(i+1, nums, current, result);

            current.remove(current.size()-1);
        }

        
    }
}