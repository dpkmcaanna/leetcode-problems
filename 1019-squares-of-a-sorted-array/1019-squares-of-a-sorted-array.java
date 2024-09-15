/*
Given array is already sorted so right most element always be greatest 
But in case of negative value order will change.

So take a new result array and compare element at left most index and right most index.

save square of greatest element and move pointer to left in result array to save next value

the loop will run till left <= right

TC: O(n)
SC: O(n)

*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int r = nums.length - 1;
        int[] res = new int[r + 1];
        int i = r;

        for(int l = 0; l <= r;) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;     
            }
            i--;
        }

        return res;
    }
}