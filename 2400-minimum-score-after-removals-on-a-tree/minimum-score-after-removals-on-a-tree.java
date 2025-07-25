class Solution {

    List<List<Integer>> adjList = new ArrayList<>();
    int minScore = Integer.MAX_VALUE;
    int totalXOR = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        //  populate
        for (int[] pair: edges) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        for (int vValue: nums) {
            totalXOR ^= vValue;
        }

        // -1 means no parent exists
        dfs(0, -1, nums);
        return minScore;
    }

    private int dfs(int root, int parent, int[] nums) {
        int subtreeXOR = nums[root];

        for (int v: adjList.get(root)) {
            // don't go back (i.e. edge up)
            if (v == parent) {
                continue;
            }
            // System.out.println("Before " + v + " " + root + " " + parent);
            subtreeXOR ^= dfs(v, root, nums);
            // System.out.println("After " + v + " " + root + " " + parent);
        }

        // now, let's divide the second tree
        // with the first one being cut at the parent value
        // at this step
        for (int v: adjList.get(root)) {
            // so if the vertex is equal parent one

            // here should be a call to subdivide subtree further

            if (v == parent) {
                dfsOfSecondPartition(v, root, subtreeXOR, nums, root);
            }
            // System.out.println("Second " + v + " " + root + " " + parent);
            // System.out.println();
        }

        return subtreeXOR;
    }

    private int dfsOfSecondPartition(int root, int parent, 
                                     int subtreeXOR, int[] nums, int p2) {
        int currXOR = nums[root];
        for (int v: adjList.get(root)) {
            if (v == parent) {
                continue;
            }
            currXOR ^= dfsOfSecondPartition(v, root, subtreeXOR, nums, p2);
        }
        // exit here since second cut shouldn't be where the first one is
        if (parent == p2) {
            return currXOR;
        }

        // System.out.println("WOWIE " + computeXORAndDifference(subtreeXOR, currXOR, totalXOR ^ currXOR ^ subtreeXOR));
        // System.out.println(subtreeXOR + " " + currXOR + " " + totalXOR);

        minScore = Math.min(minScore, 
                computeDifference(subtreeXOR, currXOR, 
                                        totalXOR ^ currXOR ^ subtreeXOR));
        return currXOR;
    }

    private int computeDifference(int firstSubtree, 
                                        int secondSubtree,
                                        int thirdPart) {
        return (
            Math.max(firstSubtree, Math.max(secondSubtree, thirdPart)) - 
            Math.min(firstSubtree, Math.min(secondSubtree, thirdPart))
        );
    }
}