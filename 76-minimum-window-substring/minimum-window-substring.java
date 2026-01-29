class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        for(char c : t_arr){
            arr[c]++;
        }

        int l=0,r =0;
        int minlen =Integer.MAX_VALUE;
        int counter =0;
        String ans ="";

        while(r < s_arr.length){
            char currchar= s_arr[r];
            if(--arr[currchar] >= 0){
                counter++;
            }

            
            while(counter == t_arr.length){
              int windowsize = r-l+1;
              if(windowsize < minlen){
                 minlen =windowsize;
                 ans = s.substring(l, r+1);
              }
              int leftchar = s_arr[l];
              if(++arr[leftchar]>0){
                counter--;
              }
              l++;
            }
            r++;
        }

        return ans;
    }
}