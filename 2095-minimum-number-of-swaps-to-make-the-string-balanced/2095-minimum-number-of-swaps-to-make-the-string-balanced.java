class Solution {
    public int minSwaps(String s) {
        int len = s.length();

        if(len == 0 || (len % 2) != 0) return 0;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty() || st.peek() == ']') {
                    st.push(c);
                } else {
                    st.pop();
                }
            }
        }
        int totalBracket = st.isEmpty() ? 0 : st.size() / 2;
        
        return (totalBracket + 1) / 2;
    }
}