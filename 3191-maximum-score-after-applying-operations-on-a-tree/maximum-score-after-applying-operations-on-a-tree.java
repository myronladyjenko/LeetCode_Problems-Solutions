class Solution {


    int[] valuesNew;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        // create adjacency matrix
        List<List<Integer>> matrix = new ArrayList<>();
        valuesNew = values;
        
        for (int i = 0; i < values.length; i++) {
            matrix.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            
            // symmetrically asign
            matrix.get(v1).add(v2);
            matrix.get(v2).add(v1);
        }
        
        long sum = 0;
        // so we can pass and maintain score
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        
        long score = dfs(0, matrix, -1);
        return sum - score;
    }
    
    private long dfs(int node, List<List<Integer>> matrix, int pre) {
        long ans = Long.MAX_VALUE;
        ans = valuesNew[node];
        
        long curr = 0;
        boolean flag = false;
        for (int child: matrix.get(node)) {
            if (child != pre) {
                flag = true;
                curr += dfs(child, matrix, node);
            }
        }
        
        if (flag) {
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}