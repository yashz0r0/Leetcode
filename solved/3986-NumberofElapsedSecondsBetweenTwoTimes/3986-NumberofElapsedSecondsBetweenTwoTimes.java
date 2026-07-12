// Last updated: 12/07/2026, 16:43:26
1class Solution {
2    public int secondsBetweenTimes(String st, String et) {
3        int hour=Integer.parseInt(et.substring(0,2))-Integer.parseInt(st.substring(0,2));
4        System.out.println(hour);
5        int min=Integer.parseInt(et.substring(3,5))-Integer.parseInt(st.substring(3,5));
6        int sec=Integer.parseInt(et.substring(6))-Integer.parseInt(st.substring(6));
7        return hour*60*60+min*60+sec;
8        
9    }
10}