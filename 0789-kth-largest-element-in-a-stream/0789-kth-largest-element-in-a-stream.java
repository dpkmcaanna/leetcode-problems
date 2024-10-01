class KthLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            q.offer(n);
            if (q.size() == k + 1) {
                q.poll();
            }
        }
    }

    public int add(int val) {
        if(q.size() < k || val > q.peek()) {
            q.offer(val);
            if (q.size() == k + 1) {
                q.poll();
            }
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */