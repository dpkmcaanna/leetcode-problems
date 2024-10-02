class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0, start = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k) {
                minLen = Math.min(minLen, i - start + 1);
                while (sum >= k && start <= i) {
                    sum -= nums[start++];
                    if (sum >= k) {
                        minLen = Math.min(minLen, i - start + 1);
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}