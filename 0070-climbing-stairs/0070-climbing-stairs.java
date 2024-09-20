class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        
        int tmp, last = 1, prv = 1;
        
        for(int i = 1; i <= n-1; i++) {
            tmp = prv;
            prv = prv + last;
            last = tmp;
        }
        
        return prv;
    }
}