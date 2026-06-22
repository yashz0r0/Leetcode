// Last updated: 23/06/2026, 00:03:19
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = events.length;
        int i = 0; // index for events array
        int res = 0;
        int d = 0; // current day
        
        while (i < n || !pq.isEmpty()) {
            // If no events are active, skip to the start day of the next event
            if (pq.isEmpty()) {
                d = events[i][0];
            }
            
            // Add all events that start on or before day 'd'
            while (i < n && events[i][0] <= d) {
                pq.offer(events[i][1]);
                i++;
            }
            
            // Remove events that have already ended before day 'd'
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            
            // Attend the event that ends the earliest
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
                d++; // Move to the next day
            }
        }
        
        return res;
    }
}