class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for(int i = 0; i < len;) {
            if(nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}