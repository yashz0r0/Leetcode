// Last updated: 23/06/2026, 00:00:59
class Solution {

    // ---------- Persistent Segment Tree Node ----------
    static class Node {
        Node left, right;
        int count;       // number of values in this segment
        long sum;        // sum of values in this segment
    }

    // ---------- Group Structure (each remainder group) ----------
    static class Group {
        int[] indices;             // positions in original nums[]
        int[] compressed;          // compressed values (vals/k)
        long[] realVal;            // decompressed values by index
        Node[] roots;              // persistent roots
        int M;                     // size of compressed domain
    }

    // Build new Node copied from old
    Node newNode(Node old) {
        Node n = new Node();
        if (old != null) {
            n.left = old.left;
            n.right = old.right;
            n.count = old.count;
            n.sum = old.sum;
        }
        return n;
    }

    // Update PST: add value at compressed index
    Node update(Node prev, int l, int r, int pos, long realVal) {
        Node cur = newNode(prev);
        cur.count++;
        cur.sum += realVal;

        if (l == r) return cur;

        int mid = (l + r) >>> 1;
        if (pos <= mid) cur.left = update(prev == null ? null : prev.left, l, mid, pos, realVal);
        else cur.right = update(prev == null ? null : prev.right, mid + 1, r, pos, realVal);

        return cur;
    }

    // Query count, sum in range [ql, qr]
    long[] query(Node rNode, Node lNode, int l, int r, int ql, int qr) {
        if (r < ql || l > qr || rNode == null) return new long[]{0, 0};
        if (ql <= l && r <= qr) {
            long cnt = rNode.count - (lNode == null ? 0 : lNode.count);
            long sum = rNode.sum - (lNode == null ? 0 : lNode.sum);
            return new long[]{cnt, sum};
        }
        int mid = (l + r) >>> 1;
        long[] L = query(rNode.left, lNode == null ? null : lNode.left, l, mid, ql, qr);
        long[] R = query(rNode.right, lNode == null ? null : lNode.right, mid + 1, r, ql, qr);
        return new long[]{L[0] + R[0], L[1] + R[1]};
    }

    // Find k-th smallest
    int kth(Node rNode, Node lNode, int l, int r, int k) {
        if (l == r) return l;
        int leftCount =
            (rNode.left == null ? 0 : rNode.left.count) -
            (lNode == null || lNode.left == null ? 0 : lNode.left.count);

        int mid = (l + r) >>> 1;
        if (k <= leftCount)
            return kth(rNode.left, lNode == null ? null : lNode.left, l, mid, k);
        else
            return kth(rNode.right, lNode == null ? null : lNode.right, mid + 1, r, k - leftCount);
    }

    // ------------------- MAIN SOLUTION -------------------
    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int n = nums.length;

        // Precompute remainders
        int[] rem = new int[n];
        for (int i = 0; i < n; i++) rem[i] = nums[i] % k;

        // Build simple segment tree for remainder min/max to check feasibility
        int[] segMin = new int[4 * n];
        int[] segMax = new int[4 * n];

        buildRem(segMin, segMax, rem, 1, 0, n - 1);

        // Group indices by remainder
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(rem[i], x -> new ArrayList<>()).add(i);
        }

        // Build PST groups
        HashMap<Integer, Group> groups = new HashMap<>();

        for (var e : map.entrySet()) {
            int r = e.getKey();
            List<Integer> list = e.getValue();

            Group G = new Group();
            G.indices = list.stream().mapToInt(x -> x).toArray();

            int m = G.indices.length;
            long[] raw = new long[m];

            for (int i = 0; i < m; i++) raw[i] = nums[G.indices[i]] / k;

            // compress raw values
            long[] sorted = raw.clone();
            Arrays.sort(sorted);
            sorted = Arrays.stream(sorted).distinct().toArray();
            G.M = sorted.length;

            G.realVal = new long[G.M + 1];
            for (int i = 0; i < sorted.length; i++) G.realVal[i + 1] = sorted[i];

            G.compressed = new int[m];
            for (int i = 0; i < m; i++) {
                int pos = Arrays.binarySearch(sorted, raw[i]);
                G.compressed[i] = pos + 1;
            }

            // Build PST prefix roots
            G.roots = new Node[m + 1];
            G.roots[0] = null;

            for (int i = 0; i < m; i++) {
                G.roots[i + 1] = update(G.roots[i], 1, G.M, G.compressed[i], raw[i]);
            }

            groups.put(r, G);
        }

        long[] ans = new long[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int L = queries[qi][0];
            int R = queries[qi][1];

            int minR = queryMin(segMin, 1, 0, n - 1, L, R);
            int maxR = queryMax(segMax, 1, 0, n - 1, L, R);

            if (minR != maxR) {
                ans[qi] = -1;
                continue;
            }

            Group G = groups.get(minR);

            int lpos = lowerBound(G.indices, L);
            int rpos = upperBound(G.indices, R) - 1;

            int cnt = rpos - lpos + 1;
            if (cnt <= 0) {
                ans[qi] = 0;
                continue;
            }

            Node leftRoot = G.roots[lpos];
            Node rightRoot = G.roots[rpos + 1];

            int medianIndex = (cnt + 1) / 2;
            int medPos = kth(rightRoot, leftRoot, 1, G.M, medianIndex);
            long median = G.realVal[medPos];

            long[] left = query(rightRoot, leftRoot, 1, G.M, 1, medPos);
            long leftCnt = left[0], leftSum = left[1];

            long[] total = query(rightRoot, leftRoot, 1, G.M, 1, G.M);
            long totalSum = total[1];
            long rightCnt = cnt - leftCnt;
            long rightSum = totalSum - leftSum;

            long ops = median * leftCnt - leftSum + rightSum - median * rightCnt;
            ans[qi] = ops;
        }

        return ans;
    }

    // ---------- Utility: remainder segtree ----------
    void buildRem(int[] stMin, int[] stMax, int[] a, int p, int l, int r) {
        if (l == r) {
            stMin[p] = stMax[p] = a[l];
            return;
        }
        int m = (l + r) >>> 1;
        buildRem(stMin, stMax, a, p << 1, l, m);
        buildRem(stMin, stMax, a, p << 1 | 1, m + 1, r);
        stMin[p] = Math.min(stMin[p << 1], stMin[p << 1 | 1]);
        stMax[p] = Math.max(stMax[p << 1], stMax[p << 1 | 1]);
    }

    int queryMin(int[] stMin, int p, int l, int r, int L, int R) {
        if (r < L || R < l) return Integer.MAX_VALUE;
        if (L <= l && r <= R) return stMin[p];
        int m = (l + r) >>> 1;
        return Math.min(queryMin(stMin, p << 1, l, m, L, R),
                        queryMin(stMin, p << 1 | 1, m + 1, r, L, R));
    }

    int queryMax(int[] stMax, int p, int l, int r, int L, int R) {
        if (r < L || R < l) return Integer.MIN_VALUE;
        if (L <= l && r <= R) return stMax[p];
        int m = (l + r) >>> 1;
        return Math.max(queryMax(stMax, p << 1, l, m, L, R),
                        queryMax(stMax, p << 1 | 1, m + 1, r, L, R));
    }

    // ---------- binary search helpers ----------
    int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
