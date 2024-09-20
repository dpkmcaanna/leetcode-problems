class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if(p1[1] == p2[1]) return 0;
            if(p1[1] < p2[1]) return -1;
            return 1;
        });
        
        int prvEndPoint = points[0][1];
        int arrows = 1;
        int len = points.length;

        for(int i = 1; i < len; i ++) {
            if(prvEndPoint < points[i][0]) {
                prvEndPoint = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }
}