class Solution {
    public int findString(String[] words, String s) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(words[i]==""){
                continue;
            }else{
                map.put(words[i],i);
            }
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        return -1;
    }
}
