class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();

        Stack<Integer> stack = new Stack();

        for(int num : nums2){

            while(!stack.isEmpty() && stack.peek() <num){
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        int[] result = new int[nums1.length];
         int index = 0;
        for(int num : nums1){
            result[index++] = map.getOrDefault(num,-1);
        }

        return result;
    }
}