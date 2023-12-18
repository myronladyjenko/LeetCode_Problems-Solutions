class Solution {
    public long minimumCost(int[] nums) {
        long totalMinCost = 0;
        int n = nums.length;
        long average = 0;
        int palindrome = -1;
        int palindrome1 = 0;
        int palindrome2 = 0;        
        
        Arrays.sort(nums);
        int av = 0;
        for (int i = 0; i < n; i++) {
            av = av + nums[i];
        }
        System.out.println(av / n);
        
        
        if (n % 2 == 1) {
            average = nums[n / 2];
            // System.out.println(average);
            palindrome = calculatePalindrome(average, nums);
            // System.out.println(palindrome);
            
            for (int i = 0; i < n; i++) {
                totalMinCost = totalMinCost + Math.abs(nums[i] - palindrome);
            }
        } else {
            // needs special attention
            palindrome1 = calculatePalindrome(nums[n / 2], nums);
            palindrome2 = calculatePalindrome(nums[(n - 1) / 2], nums);
            
            for (int i = 0; i < n; i++) {
                totalMinCost = totalMinCost + Math.abs(nums[i] - palindrome1);
            }
            
            long min = 0;
            for (int i = 0; i < n; i++) {
                min = min + Math.abs(nums[i] - palindrome2);
            }
            
            if (min < totalMinCost) {
                totalMinCost = min;
            }
        }
        return totalMinCost;
    }
    
    private int calculatePalindrome(long average, int[] nums) {
        int palindrome = 0;
        
        if (isPalindrome(average)) {
            // found it
            palindrome = (int) average;
        } else {
            // search for it
            long candidate1 = 0;
            long candidate2 = 0;
            candidate1 = findSmallerPalindrome(average - 1);
            candidate2 = findLargerPalindrome(average + 1);
            
            if (candidate1 >= (long) Math.pow(10, 9) && candidate2 >= (long) Math.pow(10, 9)) {
                palindrome = (int) ((long) Math.pow(10, 9) - 1);
            }
                long totalMinCost = 0;
                int n = nums.length;
                for (int i = 0; i < n; i++) {
                    totalMinCost = totalMinCost + Math.abs(nums[i] - candidate1);
                }

                long min = 0;
                for (int i = 0; i < n; i++) {
                    min = min + Math.abs(nums[i] - candidate2);
                }

                if (min < totalMinCost) {
                    return (int) candidate2;
                } else {
                    return (int) candidate1;
                }
        }
        return palindrome;
    }
    
    private long findSmallerPalindrome(long k) {
        while (!isPalindrome(k)) {
            k--;
        }
        return k;
    }
    
    private long findLargerPalindrome(long k) {
        while (!isPalindrome(k)) {
            k++;
        }
        return k;
    }
    
    private boolean isPalindrome(long k) {
        String kStr = Long.toString(k);
        String reversed = new StringBuilder(kStr).reverse().toString();
        return kStr.equals(reversed);
    }
}