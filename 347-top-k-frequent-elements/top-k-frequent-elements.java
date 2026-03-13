class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();

        for(int n : nums){
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }        

        List<Integer>[] bucket = new List[nums.length+1];

        for(int key : countMap.keySet()){
                 int fequency =    countMap.get(key);
            if(bucket[fequency] == null){
                bucket[fequency] = new ArrayList();
            }

            bucket[fequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = bucket.length-1; i>=0 && index <k ; i--){
            if(bucket[i] != null){
                for(int n : bucket[i]){
                    result[index++] = n;
                    if(index == k ){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}