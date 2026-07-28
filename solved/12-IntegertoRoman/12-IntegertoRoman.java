// Last updated: 28/07/2026, 08:21:08
1class Solution {
2    public String intToRoman(int num) {
3        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
4        final String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
5
6        StringBuilder sb = new StringBuilder();
7
8        for (int i = 0; i < values.length; ++i) {
9            if (num == 0)
10                break;
11            while (num >= values[i]) {
12                sb.append(symbols[i]);
13                num -= values[i];
14            }
15        }
16
17        return sb.toString();        
18    }
19}