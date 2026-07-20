// Last updated: 20/07/2026, 13:27:48
1class MedianFinder {
2    private PriorityQueue<Integer> small;
3    private PriorityQueue<Integer> large ;
4    private boolean even;
5    
6
7    public MedianFinder() {
8        small = new PriorityQueue<>(Collections.reverseOrder());
9        large = new PriorityQueue<>();
10         even = true;
11    }
12
13
14
15    public double findMedian() {
16        if (even)
17            return (small.peek() + large.peek()) / 2.0;
18        else
19            return small.peek();
20    }
21
22    public void addNum(int num) {
23        if (even) {
24            large.offer(num);
25            small.offer(large.poll());
26        } else {
27            small.offer(num);
28            large.offer(small.poll());
29        }
30        even = !even;
31}
32}
33
34/**
35 * Your MedianFinder object will be instantiated and called as such:
36 * MedianFinder obj = new MedianFinder();
37 * obj.addNum(num);
38 * double param_2 = obj.findMedian();
39 */