class Solution {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int subArrayCount = 0;
        int len = nums.length;

        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            subArrayCount += sumFreq.getOrDefault(sum - k, 0);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return subArrayCount;
    }
}