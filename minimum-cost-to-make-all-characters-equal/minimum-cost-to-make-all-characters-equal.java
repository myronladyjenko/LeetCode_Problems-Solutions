class Solution {
    public long minimumCost(String s) {
        long minCost = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                minCost += Math.min(i + 1, s.length() - i - 1);
            }
        }

        return minCost;
    }
}