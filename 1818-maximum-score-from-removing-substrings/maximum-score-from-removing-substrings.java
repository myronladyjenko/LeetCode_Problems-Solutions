class Solution {
    public int maximumGain(String s, int x, int y) {
        // whichever is bigger, let's greedily take that 
        int totalCost = 0;
        String ab = "ab";
        String ba = "ba";

        String removeFirst = "";
        String removeSecond = "";
        int costFirst = -1;
        int costSecond = -1;
        if (x >= y) {
            removeFirst = ab;
            removeSecond = ba;
            costFirst = x;
            costSecond = y;
        } else {
            removeFirst = ba;
            removeSecond = ab;
            costFirst = y;
            costSecond = x;
        }

        String sAfterFirstRemoval = removeSubstring(s, removeFirst);
        totalCost += costFirst * ((s.length() - 
                                    sAfterFirstRemoval.length()) / 2);

        String sAfterSecondRemoval = removeSubstring(sAfterFirstRemoval, removeSecond);
        totalCost += costSecond * ((sAfterFirstRemoval.length() - 
                                    sAfterSecondRemoval.length()) / 2);

        return totalCost;
    }

    private String removeSubstring(String s, String sToRemove) {
        Stack<Character> stack = new Stack<>(); 
        StringBuilder str = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (!stack.empty() && ch == sToRemove.charAt(1) &&
                stack.peek() == sToRemove.charAt(0)) {
                // remove the second character of the pair (from sToRemove)
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.empty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}