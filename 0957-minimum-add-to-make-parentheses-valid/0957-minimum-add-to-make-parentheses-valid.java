class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else {
                if(open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return open + close;
    }
}