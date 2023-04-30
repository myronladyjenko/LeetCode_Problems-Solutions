class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        if (l < 3) {
            return new ArrayList<List<Integer>>();
        }
    
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < l; i++) {
            int numOne = nums[i];
            int k = i + 1;
            int m = l - 1;

            while (k < m) {
                if (i == k) {
                    k++;
                    continue;
                }

                if (i == m) {
                    m--;
                    continue;
                }

                int currSum = numOne + nums[k] + nums[m];
                if (currSum == 0) {
                    List<Integer> li = new ArrayList<>();

                    li.add(numOne);
                    li.add(nums[k]);
                    li.add(nums[m]);
                    list.add(li);

                    while (k < m && nums[m] == nums[m - 1]) {
                        m--;
                    }

                    while (k < m && nums[k] == nums[k + 1]) {
                        k++;
                    }

                    k++;
                    m--;
                } else if (currSum > 0) {
                    m--;
                } else {
                    k++;
                } 
            }

            while (i < nums.length - 1  && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return list;
    }
}