class MyCalendar {
    int start;
    int end;

    TreeMap<Integer, Integer> cal = new TreeMap<>();

    public MyCalendar() {
        this.start = 0;
        this.end = 0;
    }

    public boolean book(int start, int end) {
        Integer prevStartTime = cal.lowerKey(end);
        if (prevStartTime != null && start <= (cal.get(prevStartTime) - 1)) {
            return false;
        }
        cal.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */