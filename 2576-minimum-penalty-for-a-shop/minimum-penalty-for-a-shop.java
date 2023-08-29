class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int countN = 0;
        int countY = 0;
        int[] arrN = new int[n + 1];
        int[] arrY = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                countN++;
            }
            arrN[i + 1] = countN;
            // System.out.println(arrN[i + 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                countY++;
            }
            arrY[i] = countY;
            // System.out.println(arrY[i + 1]);
        }

        int index = -1;
        for (int i = 0; i < n + 1; i++) {
            // System.out.println(arrN[i] + arrY[i]);
            if (arrN[i] + arrY[i] < min) {
                min = arrN[i] + arrY[i];
                if (index != i) {
                    index = i;
                }
            }
        }

        return index;
    }
}