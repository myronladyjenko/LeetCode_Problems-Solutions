class Solution {
    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        int n = nums.length;
        int finalIndex = n - 1;
        List<Integer> maxValLocations = new ArrayList<>();
        int currMaxVal;
        
        // find max value
        int maxVal = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }
        
        // pre-processing
        int countMaxVal = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxVal) {
                countMaxVal++;
                maxValLocations.add(i);
            }
        }
        if (countMaxVal < k) {
            return 0;
        }
        
        // more than k so need to count subarrays
        int beginMaxValIndex;
        int previousBeginMaxValIndex = 0;
        for (int i = 0; i < maxValLocations.size(); i++) {
            int endMaxValIndex = 0;
            beginMaxValIndex = maxValLocations.get(i);
            if (i + (k - 1) < maxValLocations.size()) {
                endMaxValIndex = maxValLocations.get(i + (k - 1));     
            } else {
                break;
            }

            // calculate number of subarrays for this case of maxVals
            long fromStartToFirst = (beginMaxValIndex - previousBeginMaxValIndex);
            long fromLastToEnd = (finalIndex - endMaxValIndex);
            answer = answer + (1 + fromStartToFirst + fromLastToEnd + (fromStartToFirst * fromLastToEnd));
            previousBeginMaxValIndex = beginMaxValIndex + 1;
        }
            
        return answer;
    }
}