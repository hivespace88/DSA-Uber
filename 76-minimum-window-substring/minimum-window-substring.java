class Solution {
    public String minWindow(String s, String t) {

       Map<Character, Integer> need = new HashMap();

       for(char ch : t.toCharArray()){
        need.put(ch, need.getOrDefault(ch,0)+1);
       }

       int required = need.size();
       int formed = 0; 
       int minLen = Integer.MAX_VALUE;
       int start = 0;

       int left =0;
       int right =0;

       Map<Character,Integer> window = new HashMap();

       while(right < s.length()){
         
         char c = s.charAt(right);
         window.put(c, window.getOrDefault(c,0)+1);
         if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
            formed++;
         }

         

         while(left <= right && formed == required){

            if(right-left+1 < minLen){
                minLen = right-left+1;
                start = left;
            }
           char removechar = s.charAt(left);
           window.put(removechar, window.get(removechar)-1);

           if(need.containsKey(removechar) && window.get(removechar) < need.get(removechar)){
            formed--;
           }
           left++;
         }
         right++;
       }
       return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}