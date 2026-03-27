
import java.util.prefs.BackingStoreException;class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
     List<List<Integer>> result = new ArrayList();
     backtrack(candidates, 0, new ArrayList(), target, result);
     return result;
   }

   public void backtrack(int[] candidates, int start, List<Integer> current, int target, List<List<Integer>> result){

      if(target == 0){
        result.add(new ArrayList(current));
        return;
      }

      for(int i = start; i< candidates.length; i++){

        if(candidates[i] <= target){
            current.add(candidates[i]);

            backtrack(candidates, i , current, target-candidates[i],result);

            current.remove(current.size()-1);
        }
      }
   }


}   
