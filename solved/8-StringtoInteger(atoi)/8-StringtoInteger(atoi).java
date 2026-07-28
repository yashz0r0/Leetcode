// Last updated: 28/07/2026, 08:34:23
1import java.util.regex.Matcher;
2import java.util.regex.Pattern;
3import java.math.BigInteger;
4
5class Solution {
6    public int myAtoi(String s) {
7      
8        s = s.stripLeading();
9        if (s.isEmpty()) return 0;
10
11        Pattern pattern = Pattern.compile("^([+-]?\\d+)");
12        Matcher matcher = pattern.matcher(s);
13        if (!matcher.find()) {
14            return 0;
15        }
16
17        String extractedNum = matcher.group(1);
18
19        BigInteger bigNum = new BigInteger(extractedNum);
20
21        if (bigNum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
22            return Integer.MAX_VALUE;
23        }
24        if (bigNum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
25            return Integer.MIN_VALUE;
26        }
27
28        return bigNum.intValue();
29    }
30}
31