class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        int intervalStartTime = intervals[0][0];
        int intervalEndTime = intervals[0][1];

        List<int []> result = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++) {
            if(intervalEndTime >= intervals[i][0]) {
                intervalEndTime = Math.max(intervalEndTime, intervals[i][1]);
            } else {
                result.add(new int[]{intervalStartTime, intervalEndTime});

                intervalStartTime = intervals[i][0];
                intervalEndTime = intervals[i][1];               
            }
        }
        result.add(new int[]{intervalStartTime, intervalEndTime});
      
        return result.toArray(new int[result.size()][]);
    }
}