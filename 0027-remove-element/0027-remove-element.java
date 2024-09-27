class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length - 1;
        int i = 0;
        int t = 0;
        while(i <= k) {
            if(nums[k] == val) {
                k--;
                continue;
            }
            if(nums[i] == val) {
                t = nums[k];
                nums[k--] = nums[i];
                nums[i++] = t;
            } else {
                i++;
            }
        }
        return k + 1;
    }
}