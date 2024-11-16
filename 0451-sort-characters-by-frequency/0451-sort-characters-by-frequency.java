class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charFq = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            charFq.put(c, charFq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        for(Map.Entry<Character, Integer> e : charFq.entrySet()) {
            pq.offer(new Element(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 0) {
            Element el = pq.poll();
            while(el.frq > 0) {
                sb.append(el.ch);
                el.frq--;
            }
        }

        return sb.toString();
    }
}

class Element implements Comparable<Element> {
    char ch;
    int frq;

    public Element(char c, int f) {
        this.ch = c;
        this.frq = f;
    }

    public int compareTo(Element el) {
        return el.frq - this.frq;
    }
}