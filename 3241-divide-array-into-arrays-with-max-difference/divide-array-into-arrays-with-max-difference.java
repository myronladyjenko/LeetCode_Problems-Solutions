class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] empty = new int[0][0];
        int[][] ans = new int[n / 3][3];
        
        Arrays.sort(nums);
        int rowCounter = 0;
        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return empty;
            }
            
            ans[rowCounter][0] = nums[i];
            ans[rowCounter][1] = nums[i + 1]; 
            ans[rowCounter][2] = nums[i + 2];
            rowCounter++;
        }
        
        return ans;
    }
}