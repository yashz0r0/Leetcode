// Last updated: 13/07/2026, 22:58:19
1class LFUCache {
2
3    HashMap<Integer, Integer> keyToValue;
4    HashMap<Integer, Integer> keyToFreq;
5    HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
6    int capacity;
7    int minFreq;
8
9    public LFUCache(int capacity) {
10        keyToValue = new HashMap<>();
11        keyToFreq = new HashMap<>();
12        freqToKey = new HashMap<>();
13        this.capacity = capacity;
14        minFreq = 0;
15    }
16    
17    public int get(int key) {
18        if (!keyToValue.containsKey(key)) {
19            return -1;
20        }
21
22        int curr = keyToValue.get(key);
23        int freq = keyToFreq.get(key);
24        freqToKey.get(freq).remove(key);
25
26        if (freqToKey.get(freq).isEmpty()) {
27            freqToKey.remove(freq);
28            if (minFreq == freq) {
29                minFreq++;
30            }
31        }
32
33        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
34        freqToKey.get(freq + 1).add(key);
35        keyToFreq.put(key, freq + 1);
36
37        return curr;
38    }
39    
40    public void put(int key, int value) {
41        if (capacity == 0) return;
42
43        if (keyToValue.containsKey(key)) {
44            keyToValue.put(key, value);
45            get(key);
46            return;
47        }
48
49        if (keyToValue.size() == capacity) {
50            LinkedHashSet<Integer> st = freqToKey.get(minFreq);
51            int oldKey = st.iterator().next();
52            st.remove(oldKey);
53            if (st.isEmpty()) {
54                freqToKey.remove(minFreq);
55            }
56            keyToFreq.remove(oldKey);
57            keyToValue.remove(oldKey);
58        }
59
60        keyToValue.put(key, value);
61        keyToFreq.put(key, 1);
62        minFreq = 1;
63        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
64        freqToKey.get(1).add(key);
65    }
66}