class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
       int[]letters=new int[26];
        Arrays.fill(letters,-1);
        for (int i = 0; i <s.length() ; i++) {
            //记录首次出现的下标
            if(letters[s.charAt(i)-'a']==-1){
                letters[s.charAt(i)-'a']=i;
            }
        }
        int max_len=-1;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(letters[s.charAt(i)-'a']!=-1){
                max_len=Math.max(max_len,i-letters[s.charAt(i)-'a']-1);
            }
        }
        return max_len;
    }
}
