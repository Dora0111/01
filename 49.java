class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = count(s);
        }
        return s;
    }

    public String count(String s) {
        char[] sc = s.toCharArray();
        int count = 1;  // 当前数值的数量
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < sc.length; i++) {
            if(sc[i] == sc[i - 1]) {    // 当前元素等于前一个元素
                count++;    // 数量+1
            } else {    // 当前元素不等于前一个元素
                sb.append(count).append(sc[i - 1]); // 把前一个元素的数量和值加入字符串
                count = 1;  // 重置
            }
        }
        sb.append(count).append(sc[sc.length - 1]);
        return sb.toString();
    }
}