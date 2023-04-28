class Solution {
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                visited[i][j] = false;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int numElem = q.size();

            for (int i = 0; i < numElem; i++) {
                int[] currCoor = q.poll();
                int currX = currCoor[0];
                int currY = currCoor[1];

                for (int j = 0; j < 4; j++) {
                    int x = currX + direction[j][0];
                    int y = currY + direction[j][1];

                    if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || visited[x][y]) {
                        continue;
                    }

                    mat[x][y] = mat[currX][currY] + 1;
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        return mat;
    }
}