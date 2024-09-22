class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> feqMap = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue<int[]> topK = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Long> e : feqMap.entrySet()) {
            topK.offer(new int[]{e.getKey(), e.getValue().intValue()});
            if(topK.size() > k) {
                topK.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!topK.isEmpty()) {
            res[i++] = topK.poll()[0];
        }
        return res;
    }
}