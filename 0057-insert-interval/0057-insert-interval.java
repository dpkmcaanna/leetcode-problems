class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int len = intervals.length;

        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;

        while (i < len && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < len && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(newInterval);

        while (i < len) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }
}