class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int sumV = 0;
        int sumH = 0;
        int result = 0;
        for (int cV: verticalCut) {
            sumV += cV;
        }
        for (int cH: horizontalCut) {
            sumH += cH;
        }

        int horCounter = horizontalCut.length - 1;
        int verCounter = verticalCut.length - 1;
        while (horCounter >= 0 && verCounter >= 0) {
            if (horizontalCut[horCounter] > verticalCut[verCounter]) {
                result += horizontalCut[horCounter] + sumV;
                sumH -= horizontalCut[horCounter];
                horCounter--;
            } else {
                result += verticalCut[verCounter] + sumH;
                sumV -= verticalCut[verCounter];
                verCounter--; 
            }
        }

        return result + sumH + sumV;
    }
}