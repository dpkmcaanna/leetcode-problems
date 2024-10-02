class Solution {
    public int jump(int[] nums) {
        int len = nums.length;

        if(len == 1) return 0;

        int maxReachableSoFar = 0;
        int lastJump = 0;
        int totalJump = 0;

        for(int i = 0; i < len; i++) {
           maxReachableSoFar = Math.max(maxReachableSoFar, i + nums[i]);
           
           if(i == lastJump) {
                lastJump = maxReachableSoFar;
                totalJump++;

                if(maxReachableSoFar >= len -1) {
                    return totalJump;
                }
           }
        }

        return totalJump;
    }
}