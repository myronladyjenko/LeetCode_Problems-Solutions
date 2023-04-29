class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
                end = i;
                // System.out.println("h " + maxLength + " " + start + " " + end + " " + i);
            } else {
                maxLength = Math.max(end - start + 1, maxLength);

                int index = map.get(ch);
                start = Math.max(start, index + 1);
                if (start > end) {
                    int temp = end;
                    end = start;
                    start = end;
                }
                end = i;

                map.put(ch, i);
                maxLength = Math.max(maxLength, end - start + 1);
                // System.out.println("a " + maxLength + " " + start + " " + end + " " + i);
            }
        }

        if (end - start + 1 > maxLength) {
            return end - start + 1;
        }

        if (maxLength == 0) {
            return end - start + 1;
        }

        return maxLength;
    }
}