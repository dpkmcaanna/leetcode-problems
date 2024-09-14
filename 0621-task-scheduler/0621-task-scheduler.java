	class Task implements Comparable<Task>{
		int frq;
		int nextExecutionTime;
		
		public Task(int frq, int nextExecutionTime) {
			super();
			this.frq = frq;
			this.nextExecutionTime = nextExecutionTime;
		}

        @Override
        public int compareTo(Task other) {
            return other.frq - this.frq;
        }
	}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
    	
    	for(int c : tasks) {
    		freq.put(c, freq.getOrDefault(c, 0) + 1);
    	}

        PriorityQueue<Task> execTak = new PriorityQueue<>();

        freq.entrySet().stream().forEach(e -> execTak.offer(new Task(e.getValue(), 0)));

        Queue<Task> waitingQ = new LinkedList<>();

        int cpuTime = 0;

        while(!execTak.isEmpty() || !waitingQ.isEmpty()) {

            if(!execTak.isEmpty()) {
            	cpuTime++;
            	Task taskWithHighFreq = execTak.poll();
                taskWithHighFreq.frq--;
                if(taskWithHighFreq.frq > 0) {
                    taskWithHighFreq.nextExecutionTime = cpuTime + n;
                    waitingQ.offer(taskWithHighFreq);
                }
            }

           if(!waitingQ.isEmpty() && waitingQ.peek().nextExecutionTime == cpuTime) {
                execTak.offer(waitingQ.poll());
            }
            
            
            if(execTak.isEmpty() && !waitingQ.isEmpty()) { 
            	cpuTime +=  waitingQ.peek().nextExecutionTime - cpuTime;
            	execTak.offer(waitingQ.poll());
            }
        }
        return cpuTime;
    }
}