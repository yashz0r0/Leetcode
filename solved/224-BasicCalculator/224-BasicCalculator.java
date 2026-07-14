// Last updated: 15/07/2026, 00:21:27
1class Solution {
2    public int calculate(String s) {
3        Stack<Long> st = new Stack<>();
4        long result = 0;
5        long num = 0;
6        long sign = 1;
7
8        for (int i = 0; i < s.length(); i++) {
9            char c = s.charAt(i);
10
11            if (Character.isDigit(c)) {
12                num = num * 10 + (c - '0');
13            }
14            else if (c == '+') {
15                result += sign * num;
16                num = 0;
17                sign = 1;
18            }
19            else if (c == '-') {
20                result += sign * num;
21                num = 0;
22                sign = -1;
23            }
24            else if (c == '(') {
25                st.push(result);
26                st.push(sign);
27                result = 0;
28                sign = 1;
29            }
30            else if (c == ')') {
31                result += sign * num;
32                num = 0;
33
34                result *= st.pop();
35                result += st.pop();
36            }
37        }
38
39        return (int)(result + sign * num);
40    }
41}