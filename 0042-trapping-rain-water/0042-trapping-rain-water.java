class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int totalWater = 0, left = 0, right = n-1;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += (leftMax - height[left]);
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += (rightMax - height[right]);
                }
                right--;
            }
        }
        return totalWater;
    }
}