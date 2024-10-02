class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sumFreq.getOrDefault(sum - k, 0);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}