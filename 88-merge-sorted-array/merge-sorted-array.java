class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int g = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[g] = nums1[i];
                g++;
                i++;
            } else {
                arr[g] = nums2[j];
                g++;
                j++;
            }
        }

        for (int k = i; k < m; k++) {
            arr[g] = nums1[k];
            g++;
        }

        for (int l = j; l < n; l++) {
            arr[g] = nums2[l];
            g++;
        }

        for (int h = 0; h < m + n; h++) {
            nums1[h] = arr[h];
        }
    }
}