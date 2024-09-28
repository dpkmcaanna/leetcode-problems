class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int t = target - (nums[l] + nums[r]);
            if(t == 0) {
                return new int[] {l + 1, r + 1};
            } else if( t > 0) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {};
    }
}