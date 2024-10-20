class Solution {
    public boolean parseBoolExpr(String ex) {
        Stack<Character> st = new Stack<>();
        List<Character> ops = new ArrayList<>();
        ops.add('!');
        ops.add('&');
        ops.add('|');

        for(char c : ex.toCharArray()) {
            if(c == ',') continue;

            if(c != ')') {
                st.push(c);
            } else {
                List<Character> val = new LinkedList<>();
                while(!st.isEmpty() && st.peek() != '(') {
                   val.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                if(ops.contains(op)) {
                    if(op == '&') {
                        if(val.contains('f')) {
                            st.push('f');
                        } else {
                            st.push('t');
                        }
                    } else if(op == '|') {
                        if(val.contains('t')) {
                            st.push('t');
                        } else {
                             st.push('f');
                        }
                    } else {
                        st.push( val.get(0) == 't' ? 'f' : 't');
                    }
                }
            }
        }
        return st.peek() == 't' ? true : false ;
    }
}