class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0, n = arr.length;

        if(n < 3) return false;

        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }

        if (count == 3)
            return true;

        for (int i = 1; i <= n - 3; i++) {
            if (arr[i + 2] % 2 != 0) {
                count++;
            }
            if (arr[i - 1] % 2 != 0) {
                count--;
            }
            if (count == 3)
                return true;
        }

        return false;
    }
}