class Solution {
    public String minWindow(String s, String t) {

       Map<Character, Integer> need = new HashMap();

       for(char c : t.toCharArray()){
        need.put(c, need.getOrDefault(c,0)+1);
       }

       int required = need.size();

       int left = 0;
       int right = 0 ;
       int formed = 0;

       int minLen = Integer.MAX_VALUE;
       int start = 0;
   
    Map<Character, Integer> window = new HashMap();
       while(right < s.length()){
             char ch =  s.charAt(right);
             window.put(ch, window.getOrDefault(ch,0)+1);

             if(need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()){
                formed++;
             }   
             
             while(left <= right && required == formed){

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