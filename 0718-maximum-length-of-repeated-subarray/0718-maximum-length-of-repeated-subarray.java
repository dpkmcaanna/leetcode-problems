class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int row = nums1.length;
        int col = nums2.length;
        int[][] dp = new int[row + 1][col + 1];

        int maxLen = Integer.MIN_VALUE;

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}