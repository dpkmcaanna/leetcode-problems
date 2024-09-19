class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], maxSumEndingHere = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; i++) {
            maxSumEndingHere = Math.max(nums[i], maxSumEndingHere + nums[i]);

            maxSum = Math.max(maxSum, maxSumEndingHere);
        }
        return maxSum;
    }
}