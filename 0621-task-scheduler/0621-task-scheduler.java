class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> execTak = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        freq.entrySet().stream().forEach(e -> execTak.offer(new int[] { e.getValue(), 0 }));

        Queue<int[]> waitingQ = new LinkedList<>();

        int cpuTime = 0;

        while (!execTak.isEmpty() || !waitingQ.isEmpty()) {

            if (!execTak.isEmpty()) {
                cpuTime++;
                int[] taskWithHighFreq = execTak.poll();
                taskWithHighFreq[0]--;
                if (taskWithHighFreq[0] > 0) {
                    taskWithHighFreq[1] = cpuTime + n;
                    waitingQ.offer(taskWithHighFreq);
                }
            }

            if (!waitingQ.isEmpty() && waitingQ.peek()[1] == cpuTime) {
                execTak.offer(waitingQ.poll());
            }

            if (execTak.isEmpty() && !waitingQ.isEmpty()) {
                cpuTime += waitingQ.peek()[1] - cpuTime;
                execTak.offer(waitingQ.poll());
            }
        }
        return cpuTime;
    }
}