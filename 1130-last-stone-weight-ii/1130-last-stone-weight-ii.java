class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int stone: stones) {
            total += stone;
        }

        int count = stones.length;

        boolean[] dp = new boolean[total/2 + 1];
        dp[0] = true;
        int maxSum = 0;
        for(int stone : stones) {
            boolean[] tmp = dp.clone();
            for(int sum = stone; sum <= total/2; sum++) {
                if(dp[sum - stone]) {
                    tmp[sum] = true;
                    maxSum = Math.max(maxSum, sum);
                    if(maxSum == total/2) {
                        return total - maxSum * 2;
                    }
                }
            }
            dp = tmp;
        }
     return total - maxSum * 2;
    }
}