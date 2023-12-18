class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int answer = 1;
        int module = (int) Math.pow(10, 9) + 7;
        int n = nums.length;
        Map<Integer, Integer> lastIndexOfEachElement = new HashMap<>();
        
        // pre-processing, find last index of each elelemt on store it in a map for easy reference
        for (int i = 0; i < n; i++) {
            lastIndexOfEachElement.put(nums[i], i);
        }
        
        // if we found some split, then multiple number of partitions by 2
        // this works because if we have n partions, number of ways to split them is 2^(n-1)
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i > index) {
                answer = (answer * 2) % module;   
            }
            index = Math.max(index, lastIndexOfEachElement.get(nums[i]));
        }
        return (int) (answer % module);
    }
}