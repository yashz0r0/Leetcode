// Last updated: 15/07/2026, 00:28:03
1import java.util.*;
2
3class Solution {
4    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
5        Map<String, Integer> evalmap = new HashMap<>();
6        for (int i = 0; i < evalvars.length; i++) evalmap.put(evalvars[i], evalints[i]);
7
8        List<String> tokens = tokenize(expression);
9        Map<List<String>, Integer> poly = parseExpression(tokens, evalmap);
10
11        List<Map.Entry<List<String>, Integer>> list = new ArrayList<>(poly.entrySet());
12        list.sort((a, b) -> {
13            if (b.getKey().size() != a.getKey().size()) return b.getKey().size() - a.getKey().size();
14            // lexicographic compare by joining with '*'
15            return String.join("*", a.getKey()).compareTo(String.join("*", b.getKey()));
16        });
17
18        List<String> ans = new ArrayList<>();
19        for (var e : list) {
20            int coeff = e.getValue();
21            if (coeff == 0) continue;
22            StringBuilder sb = new StringBuilder();
23            sb.append(coeff);
24            for (String v : e.getKey()) sb.append("*").append(v);
25            ans.add(sb.toString());
26        }
27        return ans;
28    }
29
30    private List<String> tokenize(String expr) {
31        List<String> tokens = new ArrayList<>();
32        StringBuilder sb = new StringBuilder();
33        for (char c : expr.toCharArray()) {
34            if (Character.isLetterOrDigit(c)) sb.append(c);
35            else {
36                if (sb.length() > 0) { tokens.add(sb.toString()); sb.setLength(0); }
37                if (c == '+' || c == '-' || c == '*' || c == '(' || c == ')') tokens.add(String.valueOf(c));
38            }
39        }
40        if (sb.length() > 0) tokens.add(sb.toString());
41        return tokens;
42    }
43
44    private Map<List<String>, Integer> parseExpression(List<String> tokens, Map<String, Integer> evalmap) {
45        Deque<Map<List<String>, Integer>> vals = new ArrayDeque<>();
46        Deque<String> ops = new ArrayDeque<>();
47        Map<String, Integer> prec = Map.of("+",1, "-",1, "*",2);
48
49        for (String tok : tokens) {
50            if (tok.equals("(")) ops.push(tok);
51            else if (tok.equals(")")) {
52                while (!ops.peek().equals("(")) applyOp(vals, ops.pop());
53                ops.pop();
54            } else if (prec.containsKey(tok)) {
55                while (!ops.isEmpty() && prec.containsKey(ops.peek()) && prec.get(ops.peek()) >= prec.get(tok)) {
56                    applyOp(vals, ops.pop());
57                }
58                ops.push(tok);
59            } else {
60                vals.push(parseToken(tok, evalmap));
61            }
62        }
63        while (!ops.isEmpty()) applyOp(vals, ops.pop());
64        return vals.isEmpty() ? new HashMap<>() : vals.pop();
65    }
66
67    private void applyOp(Deque<Map<List<String>, Integer>> vals, String op) {
68        Map<List<String>, Integer> b = vals.pop();
69        Map<List<String>, Integer> a = vals.pop();
70        if (op.equals("+")) vals.push(add(a, b));
71        else if (op.equals("-")) vals.push(sub(a, b));
72        else vals.push(mul(a, b));
73    }
74
75    private Map<List<String>, Integer> parseToken(String tok, Map<String, Integer> evalmap) {
76        Map<List<String>, Integer> res = new HashMap<>();
77        if (tok.matches("-?\\d+")) {
78            res.put(Collections.emptyList(), Integer.parseInt(tok));
79        } else if (evalmap.containsKey(tok)) {
80            res.put(Collections.emptyList(), evalmap.get(tok));
81        } else {
82            res.put(Arrays.asList(tok), 1);
83        }
84        return res;
85    }
86
87    private Map<List<String>, Integer> combine(Map<List<String>, Integer> m) {
88        Map<List<String>, Integer> res = new HashMap<>();
89        for (var e : m.entrySet()) {
90            if (e.getValue() != 0) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) + e.getValue());
91        }
92        res.entrySet().removeIf(kv -> kv.getValue() == 0);
93        return res;
94    }
95
96    private Map<List<String>, Integer> add(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
97        Map<List<String>, Integer> res = new HashMap<>(a);
98        for (var e : b.entrySet()) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) + e.getValue());
99        return combine(res);
100    }
101
102    private Map<List<String>, Integer> sub(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
103        Map<List<String>, Integer> res = new HashMap<>(a);
104        for (var e : b.entrySet()) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) - e.getValue());
105        return combine(res);
106    }
107
108    private Map<List<String>, Integer> mul(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
109        Map<List<String>, Integer> res = new HashMap<>();
110        for (var ea : a.entrySet()) {
111            for (var eb : b.entrySet()) {
112                List<String> merged = new ArrayList<>(ea.getKey());
113                merged.addAll(eb.getKey());
114                Collections.sort(merged);
115                res.put(merged, res.getOrDefault(merged, 0) + ea.getValue() * eb.getValue());
116            }
117        }
118        return combine(res);
119    }
120}