class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][]dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) { // s1
            for(int j = 1; j <= n; j++) { //s2
                if(s1.charAt(i - 1) == s2.charAt(j -1)) {
                    dp[i][j] = 1 + dp[i -1][j -1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcsLen = dp[m][n];

        return (m - lcsLen) + (n - lcsLen);
    }
}