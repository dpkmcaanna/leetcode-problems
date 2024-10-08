class Solution {
    public int minSwaps(String s) {
        int len = s.length();

        if (len == 0 || (len % 2) != 0)
            return 0;

        int open = 0, close = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }

        return (open + 1) / 2;
    }
}