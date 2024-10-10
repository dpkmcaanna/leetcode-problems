class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++) {
            if(st.isEmpty() || nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }

        int maxRamp = Integer.MIN_VALUE;
        for(int j = n - 1; j >= 0 ; j--) {
            while(!st.isEmpty() && nums[j] >= nums[st.peek()]) {
                maxRamp = Math.max(maxRamp, j - st.pop());
            }
            if(st.isEmpty()) {
                break;
            }
        }
        return maxRamp;
    }
}