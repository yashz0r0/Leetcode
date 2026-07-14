// Last updated: 15/07/2026, 00:26:55
1class Solution {
2    public String nearestPalindromic(String numberStr) {
3        long number = Long.parseLong(numberStr);
4        if (number <= 10) return String.valueOf(number - 1);
5        if (number == 11) return "9";
6
7        int length = numberStr.length();
8        long leftHalf = Long.parseLong(numberStr.substring(0, (length + 1) / 2));
9        
10        long[] palindromeCandidates = new long[5];
11        palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
12        palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
13        palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
14        palindromeCandidates[3] = (long)Math.pow(10, length - 1) - 1;
15        palindromeCandidates[4] = (long)Math.pow(10, length) + 1;
16
17        long nearestPalindrome = 0;
18        long minDifference = Long.MAX_VALUE;
19
20        for (long candidate : palindromeCandidates) {
21            if (candidate == number) continue;
22            long difference = Math.abs(candidate - number);
23            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
24                minDifference = difference;
25                nearestPalindrome = candidate;
26            }
27        }
28
29        return String.valueOf(nearestPalindrome);
30    }
31
32    private long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
33        long palindrome = leftHalf;
34        if (!isEvenLength) leftHalf /= 10;
35        while (leftHalf > 0) {
36            palindrome = palindrome * 10 + leftHalf % 10;
37            leftHalf /= 10;
38        }
39        return palindrome;
40    }
41}
42