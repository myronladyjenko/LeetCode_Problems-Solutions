class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int flag = 0;

        for(int[] interval: intervals) {
            if (flag == -1 || interval[1] < newInterval[0]) {
                list.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // insert newInterval
                list.add(newInterval);
                list.add(interval);
                flag = -1;
            } else {
                // recalculate indexes 
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (flag != -1) {
            list.add(newInterval);
        }

        return list.toArray(new int [0][]);
    }
}