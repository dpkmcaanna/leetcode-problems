class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
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

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while( i > 0 && j >0) {
            if(dp[i][j] > Math.max(dp[i-1][j], dp[i][j-1])) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return findSuperSubsequence(s1, s2, sb.reverse().toString());
    }

    public static String findSuperSubsequence(String s1, String s2, String lcs) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0, m = s1.length(), n = s2.length();
        for(char c : lcs.toCharArray()) {
            while(i < m && s1.charAt(i) != c ) {
                sb.append(s1.charAt(i++));
            }

            while(j < n && s2.charAt(j) != c) {
                sb.append(s2.charAt(j++));
            }

            sb.append(c);
            i++;
            j++;
        }

        if(i < m) {
            sb.append(s1.substring(i));
        }

        if(j < n) {
            sb.append(s2.substring(j));
        }

       return sb.toString();

    }
}