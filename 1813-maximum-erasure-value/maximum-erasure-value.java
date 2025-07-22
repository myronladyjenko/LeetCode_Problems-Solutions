class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        int currSum = 0;

        boolean[] seen = new boolean[10001];

        int left = 0;
        for (int right = 0; right < n; right++) {
            if (!seen[nums[right]]) {
                currSum += nums[right];
                seen[nums[right]] = true;
                continue;
            } else {
                // at this point the currSum is the maxSum
                if (currSum >= maxSum) {
                    maxSum = currSum;
                }

                // while it has been seen, we need to move
                // left pointer until the element is not seen
                while (seen[nums[right]]) {
                    seen[nums[left]] = false;
                    currSum -= nums[left];

                    left++;
                }

                // System.out.println("Hmmm: " + left + " " + right);

                // now add the new 
                currSum += nums[right];
                seen[nums[right]] = true;
            }
        }

        if (currSum >= maxSum) {
            maxSum = currSum;
        }

        return maxSum;
    }
}