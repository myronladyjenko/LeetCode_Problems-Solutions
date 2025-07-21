class Solution {
    public String makeFancyString(String s) {
        StringBuilder sToReturn = new StringBuilder();
        int n = s.length();

        char prev = s.charAt(0);
        sToReturn.append(prev);
        char curr;
        int countOfTheSame = 1;
        for (int i = 1; i < n; i++) {
            curr = s.charAt(i);

            // System.out.println();
            if (curr == prev) {
                if (countOfTheSame >= 2) {
                    // do nothing
                } else {
                    sToReturn.append(curr);
                }
                countOfTheSame++;
            } else {
                prev = curr;
                countOfTheSame = 1;
                sToReturn.append(curr);
            }
        }

        return sToReturn.toString();
    }
}