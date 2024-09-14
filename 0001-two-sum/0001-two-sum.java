class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> feq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if(feq.containsKey(otherNum)) {
                return new int[]{feq.get(otherNum), i};
            } else {
                feq.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}