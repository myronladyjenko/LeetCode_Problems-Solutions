import java.math.BigInteger;

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> good = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int[] tuple = variables[i];
            
            BigInteger firstValue = BigInteger.valueOf(tuple[0]).modPow(BigInteger.valueOf(tuple[1]), BigInteger.TEN);
            BigInteger finalValue = firstValue.modPow(BigInteger.valueOf(tuple[2]), BigInteger.valueOf(tuple[3]));
            
            if (finalValue.compareTo(BigInteger.valueOf(target)) == 0) {
                good.add(i);
            }
        }
        
        return good;
    }
}