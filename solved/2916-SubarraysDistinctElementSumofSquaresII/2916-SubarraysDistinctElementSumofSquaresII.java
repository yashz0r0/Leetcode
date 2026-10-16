// Last updated: 16/10/2026, 21:43:07
1class Solution {
2    static final int MOD = 1000000007;
3    static class Node {
4        long sum, sumsq, lazy;
5    }
6    Node[] tree;
7    int n;
8    void push(int v, int tl, int tr) {
9        if (tree[v].lazy != 0 && tl != tr) {
10            int mid = (tl + tr) >> 1;
11            int llen = mid - tl + 1, rlen = tr - mid;
12            long add = tree[v].lazy;
13            tree[v << 1].sumsq = (tree[v << 1].sumsq + 2 * add * tree[v << 1].sum + add * add % MOD * llen) % MOD;
14            tree[v << 1].sum = (tree[v << 1].sum + add * llen) % MOD;
15            tree[v << 1].lazy = (tree[v << 1].lazy + add) % MOD;
16            tree[v << 1 | 1].sumsq = (tree[v << 1 | 1].sumsq + 2 * add * tree[v << 1 | 1].sum + add * add % MOD * rlen) % MOD;
17            tree[v << 1 | 1].sum = (tree[v << 1 | 1].sum + add * rlen) % MOD;
18            tree[v << 1 | 1].lazy = (tree[v << 1 | 1].lazy + add) % MOD;
19            tree[v].lazy = 0;
20        }
21    }
22    void update(int v, int tl, int tr, int l, int r, long add) {
23        if (l > r) return;
24        if (l == tl && r == tr) {
25            int len = tr - tl + 1;
26            tree[v].sumsq = (tree[v].sumsq + 2 * add * tree[v].sum + add * add % MOD * len) % MOD;
27            tree[v].sum = (tree[v].sum + add * len) % MOD;
28            tree[v].lazy = (tree[v].lazy + add) % MOD;
29            return;
30        }
31        push(v, tl, tr);
32        int mid = (tl + tr) >> 1;
33        update(v << 1, tl, mid, l, Math.min(r, mid), add);
34        update(v << 1 | 1, mid + 1, tr, Math.max(l, mid + 1), r, add);
35        tree[v].sum = (tree[v << 1].sum + tree[v << 1 | 1].sum) % MOD;
36        tree[v].sumsq = (tree[v << 1].sumsq + tree[v << 1 | 1].sumsq) % MOD;
37    }
38    long query(int v, int tl, int tr, int l, int r) {
39        if (l > r) return 0;
40        if (l == tl && r == tr) return tree[v].sumsq;
41        push(v, tl, tr);
42        int mid = (tl + tr) >> 1;
43        return (query(v << 1, tl, mid, l, Math.min(r, mid)) + query(v << 1 | 1, mid + 1, tr, Math.max(l, mid + 1), r)) % MOD;
44    }
45    public int sumCounts(int[] nums) {
46        n = nums.length;
47        tree = new Node[4 * n];
48        for (int i = 0; i < tree.length; i++) tree[i] = new Node();
49        int[] last = new int[100001];
50        Arrays.fill(last, -1);
51        long ans = 0;
52        for (int r = 0; r < n; r++) {
53            int prv = last[nums[r]];
54            if (prv + 1 <= r - 1) update(1, 0, n - 1, prv + 1, r - 1, 1);
55            update(1, 0, n - 1, r, r, 1);
56            ans = (ans + query(1, 0, n - 1, 0, r)) % MOD;
57            last[nums[r]] = r;
58        }
59        return (int) ans;
60    }
61}