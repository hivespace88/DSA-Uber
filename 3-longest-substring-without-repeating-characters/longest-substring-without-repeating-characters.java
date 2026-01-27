class Solution {
    public int lengthOfLongestSubstring(String s) {

     Set<Character> set = new HashSet();

     int maxLen = 0;
     int left = 0;

        for(int right =0; right<s.length();right++){
             char current = s.charAt(right);

             while(set.contains(current)){
                set.remove(s.charAt(left));
                left++;
             }

             set.add(current);

             maxLen =Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}