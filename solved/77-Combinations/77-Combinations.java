// Last updated: 13/10/2026, 08:03:11
1class Solution {
2    public static List<List<Integer>> combine(int n, int k) {
3		List<List<Integer>> combs = new ArrayList<List<Integer>>();
4		combine(combs, new ArrayList<Integer>(), 1, n, k);
5		return combs;
6	}
7	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
8		if(k==0) {
9			combs.add(new ArrayList<Integer>(comb));
10			return;
11		}
12		for(int i=start;i<=n;i++) {
13			comb.add(i);
14			combine(combs, comb, i+1, n, k-1);
15			comb.remove(comb.size()-1);
16		}
17	}
18}