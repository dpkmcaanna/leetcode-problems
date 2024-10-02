class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = Integer.MIN_VALUE;

        Map<Integer, Integer> prvSum = new HashMap<>();
        prvSum.put(0, -1);

        int sum = 0, start = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] == 0 ? -1 : 1);
            if(prvSum.containsKey(sum)) {
                start = prvSum.get(sum) + 1;
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                prvSum.put(sum, i);
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}