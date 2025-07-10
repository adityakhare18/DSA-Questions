class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair other) {
            return this.freq - other.freq;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char ch : map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            sb.append(p1.ch);
            sb.append(p2.ch);

            p1.freq--;
            p2.freq--;

            if (p1.freq > 0) pq.add(p1);
            if (p2.freq > 0) pq.add(p2);
        }

        if (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (last.freq > 1) return "";
            sb.append(last.ch);
        }

        return sb.toString();
    }
}
