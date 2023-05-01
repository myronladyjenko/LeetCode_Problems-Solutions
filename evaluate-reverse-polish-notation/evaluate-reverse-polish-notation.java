class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*") )) {
                st.push(Integer.parseInt(tokens[i]));
            } else {
                if (tokens[i].equals("+")) {
                    st.push(st.pop() + st.pop());
                } else if (tokens[i].equals("-")) {
                    int val1 = st.pop();
                    st.push(st.pop() - val1);   
                } else if (tokens[i].equals("*")) {
                    st.push(st.pop() * st.pop());
                } else if (tokens[i].equals("/")) {
                    int val1 = st.pop();
                    st.push(st.pop() / val1);
                }
            }
        }

        return st.pop();
    }
}