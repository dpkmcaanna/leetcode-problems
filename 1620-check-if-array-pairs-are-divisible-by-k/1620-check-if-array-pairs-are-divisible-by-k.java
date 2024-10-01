class Solution {
    public boolean canArrange(int[] arr, int k) {
        //Map<Integer, Integer> pairs = new HashMap<>();
        int[] pairs = new int[k];
        for(int e : arr) {
            int rem = ((e % k) + k) % k;
            pairs[rem]++;
        }

        if(pairs[0]%2 != 0) {
            return false;
        }

        for(int i = 1; i < k/2; i++) {
            if(pairs[i] != pairs[k-i]){
                return false;
            }
        }
        return true;
    }
}