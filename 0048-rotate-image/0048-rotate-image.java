/*
There are two rotation required.
1. Rotate the array along diagonal and then
2. Rotate along the id column 
*/
class Solution {
    public void rotate(int[][] m) {
        int n = m.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                //swap along diagonal
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }

        int c = m[0].length;
        int mid = c/2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < mid ; j++) {
                //swap along middle column
                int t = m[i][c - j - 1];
                m[i][c - j - 1] = m[i][j];
                m[i][j] = t;
            }
        }
    }
}