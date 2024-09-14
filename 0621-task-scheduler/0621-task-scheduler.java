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

            /*
             Select task with high frequence from executable task queue and update the CPU time.
             And add to waiting queue if more CPU is requred complete the this task
            */
            if (!execTak.isEmpty()) {
                cpuTime++;
                int[] taskWithHighFreq = execTak.poll();
                taskWithHighFreq[0]--;
                if (taskWithHighFreq[0] > 0) {
                    taskWithHighFreq[1] = cpuTime + n;
                    waitingQ.offer(taskWithHighFreq);
                }
            }

            /*
            When a task is executed on CPU, then put in wiating queue for next turn
            */
            if (!waitingQ.isEmpty() && waitingQ.peek()[1] == cpuTime) {
                execTak.offer(waitingQ.poll());
            }

            /*
                Handle when there is no task in the execuatble queue due idle time is high and 
                there is no task to execute now.
            */
            if (execTak.isEmpty() && !waitingQ.isEmpty()) {
                cpuTime += waitingQ.peek()[1] - cpuTime;
                execTak.offer(waitingQ.poll());
            }
        }
        return cpuTime;
    }
}