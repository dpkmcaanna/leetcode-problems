class Solution {
    public int largestRectangleArea(int[] heights) {
      
        int n = heights.length;
        int[] stack = new int[n + 1];
        int h = 0, w = 0, top = -1, ce = 0, ps = 0;
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i <=n; i++) {
            ce = (i == n) ? 0 : heights[i];
            while(top != -1 && ce < heights[stack[top]]) {
                h =  heights[stack[top--]];
                ps = (top == -1) ? -1 : stack[top];
                w = i - ps - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack[++top] = i;       
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
}