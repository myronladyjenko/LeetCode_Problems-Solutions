class Solution {
    public String getSmallestString(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            int int1 = Character.getNumericValue(charArray[i]);
            int int2 = Character.getNumericValue(charArray[i + 1]);

            if (int1 % 2 == int2 % 2 && int2 < int1) {
                char temp = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i + 1] = temp;
                break;
            }
        }
        return new String(charArray);
    }
}