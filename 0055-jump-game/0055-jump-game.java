class Solution {
    public boolean canJump(int[] nums) {
        int maxReachableSoFar = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i > maxReachableSoFar) return false;

            maxReachableSoFar = Math.max(maxReachableSoFar, i + nums[i]);

            if(maxReachableSoFar >= (n - 1)) return true;
        }
        return false;
    }
}