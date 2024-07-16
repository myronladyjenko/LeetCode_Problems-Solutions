class Solution {
    public String getSmallestString(String s) {
        String sFinal = "";
        boolean performedSwap = false;

        for (int i = 0; i < s.length() - 1; i++) {
            int int1 = Character.getNumericValue(s.charAt(i));
            int int2 = Character.getNumericValue(s.charAt(i + 1));

            if (int1 % 2 == int2 % 2) {
                if (int2 < int1) {
                    performedSwap = true;
                    // add the lower one to a new string
                    sFinal += s.charAt(i + 1);

                    // swap the string - ONLY needed for a complicated problem
                    // String sPart1 = s.substring(0, i);
                    // String sPart2 = "";
                    // if (i + 2 < s.length()) {
                    //     sPart2 = s.substring(i + 2, s.length());
                    // }
                    // s = sPart1 + s.charAt(i + 1) + s.charAt(i) + sPart2;
                    sFinal += s.charAt(i);
                    String sPart = "";
                    if (i + 2 < s.length()) {
                        sPart = s.substring(i + 2, s.length());
                    }
                    sFinal += sPart;
                    break;
                } else {
                    sFinal += s.charAt(i);
                }
            } else {
                sFinal += s.charAt(i);
            }
        }

        if (performedSwap) {
            return sFinal;
        }
        return sFinal + s.charAt(s.length() - 1);
    }
}