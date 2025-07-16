class Solution {
    public int maximumLength(int[] nums) {
        int maxSameParity = longestSameParity(nums);

        int even = 0;
        int odd = 0;
        for (int num: nums) {
            if (num % 2 == 0) {
                even = Math.max(even, odd + 1);
            } else {
                odd = Math.max(odd, even + 1);
            }
            System.out.println(even + " " + odd);
        }


        int maxAlternatingParity = Math.max(even, odd);
        return Math.max(maxSameParity, maxAlternatingParity);
    }

    private int longestSameParity(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int num: nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return Math.max(even, odd);
    }
}