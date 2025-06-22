class Solution {

    private int nodesCostToIncrease = 0;
    
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        int u = -1;
        int v = -1;
        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0, -1, tree, cost);
        return nodesCostToIncrease;
    }

    private int dfs(int node, int parent, List<List<Integer>> tree, int[] cost) {
        List<Integer> childPathSums = new ArrayList<>();

        for (int nextNode : tree.get(node)) {
            if (nextNode != parent) {
                childPathSums.add(dfs(nextNode, node, tree, cost));
            }
        }

        if (childPathSums.isEmpty()) {
            return cost[node];
        }

        int maxChildPathSum = Collections.max(childPathSums);
        for (int sum: childPathSums) {
            if (sum < maxChildPathSum) {
                nodesCostToIncrease++;
            }
        }
        
        return cost[node] + maxChildPathSum;
    }
}