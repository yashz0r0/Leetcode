// Last updated: 23/06/2026, 00:01:14
class Solution {
    public int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append("1");
        }

        String binaryNumber = sb.toString();
        return Integer.parseInt(binaryNumber, 2);
    }
}
